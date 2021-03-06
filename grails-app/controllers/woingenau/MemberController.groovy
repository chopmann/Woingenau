package woingenau

import grails.converters.JSON
import woingenau.auth.SecUser
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

class MemberController {
    static allowedMethods = [index: 'GET', save: 'POST', delete: 'DELETE']
    static responseFormats = ['json', 'xml']

    @Secured(['ROLE_USER'])
    def index() {
        JSON.use('thin')
        if (params.courseId) {
            log.debug('CourseID: ' + params.courseId)
            respond Course.get(params.courseId)?.members
        } else {
            render status: NOT_FOUND
        }
    }

    def save() {
        log.debug('CourseID: ' + params.courseId)
        def mData = request.JSON
        def course = Course.get(params.courseId)
        def uInstance = SecUser.get(mData.id)
        if (course == null || uInstance == null) {
            render status: NOT_FOUND
            return
        }

        def isMember = uInstance in course.members
        if (!isMember) {
            course.addToMembers(uInstance)
            course.save flush: true
            JSON.use('thin')
            respond course.members, [status: CREATED]
        } else {
            def msg = "SecUser already member"
            response.status = UNPROCESSABLE_ENTITY.value()
            render([error: msg] as JSON)
        }
    }

    def delete() {
        log.debug("CourseID:  ${params.courseId}")
        def mData = request.JSON
        def course = Course.get(params.courseId)
        def uInstance = SecUser.get(mData.id)
        if (course == null || uInstance == null) {
            render status: NOT_FOUND
            return
        }
        def isMember = uInstance in course.members
        if (isMember) {
            course.removeFromMembers(uInstance)
            course.save flush: true
            JSON.use('thin')
            respond course.members, [status: OK]
        } else {
            def msg = "SecUser not member"
            response.status = NOT_FOUND.value()
            render([error: msg] as JSON)
        }
    }
}
