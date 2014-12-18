package woingenau
import grails.rest.Resource

class Appointment {
    Date start
    Date end
    String place
    static belongsTo = [course: Course]
    static constraints = {
        start(blank: false, validator: {val, obj ->
            val > obj.end ? false : true
        })
        end(blank: false, validator: {val, obj ->
            val < obj.start ? false : true
        })

    }
}
