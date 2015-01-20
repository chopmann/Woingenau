package woingenau

import woingenau.auth.SecUser

class Template {
    String name
    String faculty
    String major
    String semester
    static belongsTo = [creator: SecUser]
    static hasMany = [courses: Course]
    static constraints = {
        name blank: false
        faculty blank: true
        major blank: true
        semester blank: true
    }
}
