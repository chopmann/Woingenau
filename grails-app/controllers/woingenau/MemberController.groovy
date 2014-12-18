package woingenau

import grails.converters.JSON
import woingenau.auth.User

import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import grails.plugin.springsecurity.annotation.Secured

class MemberController {
    static allowedMethods = [index: 'GET', save: 'POST', delete: 'DELETE']
    static responseFormats = ['json', 'xml']
    @Secured(['ROLE_USER'])
    def index() {
        JSON.use('thin')
        if(params.courseId) {
            log.debug('CourseID: '+ params.courseId)
            respond Course.get(params.courseId)?.members
        } else {
            render status: NOT_FOUND
        }
    }

    def save() {
        log.debug('CourseID: ' + params.courseId)
        def mData = request.JSON
        def course = Course.get(params.courseId)
        def uInstance = User.get(mData.id)
        if (course == null || uInstance == null) {
            render status: NOT_FOUND
            return
        }

        def isMember = uInstance in course.members
        if(!isMember){
            course.addToMembers(uInstance)
            course.save flush: true
            JSON.use('thin')
            respond course.members, [status: CREATED]
        } else {
            def msg = "User already member"
            response.status = UNPROCESSABLE_ENTITY.value()
            render([error: msg] as JSON)
        }
    }

    def delete() {
        log.debug("CourseID:  ${params.courseId}")
        def mData = request.JSON
        def course = Course.get(params.courseId)
        def uInstance = User.get(mData.id)
        if (course == null || uInstance == null) {
            render status: NOT_FOUND
            return
        }
        def isMember = uInstance in course.members
        if(isMember){
            course.removeFromMembers(uInstance)
            course.save flush: true
            JSON.use('thin')
            respond course.members, [status: OK]
        } else {
            def msg = "User not member"
            response.status = NOT_FOUND.value()
            render([error: msg] as JSON)
        }
    }
}
