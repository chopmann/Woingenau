package woingenau

import grails.rest.Resource
import woingenau.auth.User

class Template {
    String name
    String faculty
    String major
    String semester
    static belongsTo = [creator: User]
    static hasMany = [courses: Course]
    static constraints = {
        name blank: false
        faculty blank: true
        major blank: true
        semester blank: true
    }
}
