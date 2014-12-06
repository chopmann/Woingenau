package woingenau

class Appointment {
    Date start
    Date end
    String place
    static belongsTo = [course: Course]
    static constraints = {
        start blank: true
        end blank: true
    }
}
