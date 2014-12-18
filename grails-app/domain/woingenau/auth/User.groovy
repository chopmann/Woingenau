package woingenau.auth

import woingenau.Course

class User {

    transient springSecurityService

    String username
    String firstname
    String lastname
    String email
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static belongsTo = Course
    static hasMany = [lecturerOf: Course, creatorOf: Course]
    static mappedBy = [lecturerOf: 'lecturer', creatorOf: 'creator']
    static transients = ['springSecurityService']
    static updatableProperties = ['firstname', 'lastname', 'password', 'email']

    static constraints = {
        username size: 4..15, blank: false, unique: true
        firstname blank: false
        lastname blank: false
        password blank: false
        //courses nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role }
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }
}
