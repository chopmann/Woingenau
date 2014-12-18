package woingenau
import grails.rest.Resource

class Appointment {
    Date start
    Date end
    String place
    boolean mandatory
    static belongsTo = [course: Course]
    static constraints = {
        mandatory defaultValue: false
        start(blank: false, validator: {val, obj ->
            val > obj.end ? false : true
        })
        end(blank: false, validator: {val, obj ->
            val < obj.start ? false : true
        })

    }
}
