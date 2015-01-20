package woingenau

import grails.rest.RestfulController
import woingenau.auth.SecUser
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
        course.creator = SecUser.get(courseData.creator.id)
        course.lecturer = SecUser.get(courseData.lecturer.id)
        courseData.members.each{memberData ->
            course.addToMembers(SecUser.get(memberData.id))
        }
        courseData.appointments.each{appointmentData ->
            appointmentData["startDate"] = appointmentData["start"]
            appointmentData.remove("start")
            appointmentData["endDate"] = appointmentData["end"]
            appointmentData.remove("end")
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
        course.creator = SecUser.get(courseData.creator.id)
        course.lecturer = SecUser.get(courseData.lecturer.id)
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
