package woingenau

import grails.rest.RestfulController
import grails.transaction.Transactional

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE
import static org.springframework.http.HttpStatus.NOT_FOUND

@Transactional()
class AppointmentController extends RestfulController{

    static responseFormats = ['json', 'xml']

    AppointmentController(){
        super(Appointment)
    }
    def index() {
        if(params.courseId) {
            log.debug('CourseID: '+ params.courseId)
            respond Course.get(params.courseId)?.appointments
        } else {
            render status: NOT_FOUND
        }
    }

    def save() {
        log.debug('CourseID: ' + params.courseId)
        def course = Course.get(params.courseId)
        if (course == null) {
            render status: NOT_FOUND
            return
        }
        def aData = request.JSON
        def sd = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
        def appointment = new Appointment()
        appointment.place = aData.place[0]
        appointment.start = sd.parse(aData.start[0])
        appointment.end = sd.parse(aData.end[0])
        course.addToAppointments(appointment)
        appointment.validate()
        if(appointment.hasErrors()) {
            log.debug(appointment.errors)
            render status: NOT_ACCEPTABLE
            return
        } else {
            appointment.save(flush: true)
            respond appointment, [status: CREATED]
        }

    }

}
