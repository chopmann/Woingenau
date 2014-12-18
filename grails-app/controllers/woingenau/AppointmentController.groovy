package woingenau

import grails.rest.RestfulController
import grails.transaction.Transactional
import java.text.SimpleDateFormat
import static org.springframework.http.HttpStatus.*

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
        def aInstance = new Appointment()
        aInstance.place = aData.place
        aInstance.start = sd.parse(aData.start)
        aInstance.end = sd.parse(aData.end)
        aInstance.mandatory = aData.mandatory ?: false
        course.addToAppointments(aInstance)
        aInstance.validate()
        if(aInstance.hasErrors()) {
            log.debug(aInstance.errors)
            render status: NOT_ACCEPTABLE
            return
        } else {
            aInstance.save(flush: true)
            respond aInstance, [status: CREATED]
        }

    }

}
