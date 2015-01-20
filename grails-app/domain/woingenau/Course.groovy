package woingenau

import woingenau.auth.SecUser


class Course {

    String title
    static belongsTo = [lecturer: SecUser, creator: SecUser]
    static hasMany = [appointments: Appointment, members: SecUser]

    static constraints = {
        title blank: false
        creator blank: false
        lecturer blank: false
    }
    static marshalling = {
        shouldOutputVersion false
        shouldOutputClass false
        deep 'appointments'
    }
}
