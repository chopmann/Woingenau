package woingenau

class Course {

    String title
    static belongsTo = [lecturer: User, creator: User]
    static hasMany = [appointments: Appointment, members: User]

    static constraints = {
        title blank: false
        creator blank: false
        lecturer blank: false
    }
}
