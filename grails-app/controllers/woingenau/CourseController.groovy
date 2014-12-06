package woingenau



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CourseController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Course.list(params), [status: OK]
    }

    @Transactional
    def save() {
/*        if (courseInstance == null) {
            render status: NOT_FOUND
            return
        }*/
        def jsonObj = request.JSON
        def appointments = [] as Set
        jsonObj.appointments.each{
            println it
            appointments << new Appointment(it, start: new Date(), end: new Date())

        }
        Course courseInstance = new Course(jsonObj)
        courseInstance.validate()
        if (courseInstance.hasErrors()) {
            render courseInstance.errors
            return
        }
        courseInstance.save flush:true
        respond courseInstance, [status: CREATED]
    }


    @Transactional
    def update(Course courseInstance) {
        if (courseInstance == null) {
            render status: NOT_FOUND
            return
        }

        courseInstance.validate()
        if (courseInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        courseInstance.save flush:true
        respond courseInstance, [status: OK]
    }

    @Transactional
    def delete(Course courseInstance) {

        if (courseInstance == null) {
            render status: NOT_FOUND
            return
        }

        courseInstance.delete flush:true
        render status: NO_CONTENT
    }
}
