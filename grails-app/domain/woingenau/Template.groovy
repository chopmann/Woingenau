package woingenau

import grails.rest.Resource
import woingenau.auth.User

@Resource
class Template {
    String name
    static belongsTo = [creator: User]
    static hasMany = [courses: Course]
    static constraints = {
        name blank: false
    }
}
