package woingenau

import grails.rest.RestfulController
import woingenau.auth.User

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional()
class CourseController extends RestfulController {

    static responseFormats = ['json', 'xml']

    CourseController() {
        super(Course)
    }

    def save() {
        def courseData = request.JSON
        def course = new Course()
        course.title = courseData.title
        course.creator = User.get(courseData.creator.id)
        course.lecturer = User.get(courseData.lecturer.id)
        courseData.members.each{memberData ->
            course.addToMembers(User.get(memberData.id))
        }
        courseData.appointments.each{appointmentData ->
            def appointment = new Appointment(appointmentData)
            course.addToAppointments(appointment)
        }
        course.validate()
        if(course.hasErrors()) {
            log.debug(course.errors)
            render status: NOT_ACCEPTABLE
            return
        } else {
            course.save(flush: true)
            respond course, [status: CREATED]
        }

    }

    def update() {
        def courseData = request.JSON
        log.debug('CourseID: ' + params.id)
        def course = Course.get(params.id)
        if (course == null) {
            render status: NOT_FOUND
            return
        }
        course.title = courseData.title
        course.creator = User.get(courseData.creator.id)
        course.lecturer = User.get(courseData.lecturer.id)
        course.validate()
        if(course.hasErrors()) {
            log.debug(course.errors)
            render status: NOT_ACCEPTABLE
            return
        } else {
            course.save(flush: true)
            respond course, [status: OK]
        }
    }
}
