package woingenau

class Appointment {
    Date startDate
    Date endDate
    String place
    boolean mandatory
    static belongsTo = [course: Course]
    static constraints = {
        mandatory defaultValue: false
        startDate(blank: false, validator: { val, obj ->
            val > obj.endDate ? false : true
        })
        endDate(blank: false, validator: { val, obj ->
            val < obj.startDate ? false : true
        })

    }
}
