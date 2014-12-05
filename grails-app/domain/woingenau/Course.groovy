package woingenau

class Course {

    String title
    static belongsTo = [owner: User, creator: User]
    static hasMany = [appointments: Appointment]

    static constraints = {
        title blank: false
        creator blank: false
        owner blank: false
    }
}
