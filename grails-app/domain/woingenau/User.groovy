package woingenau

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

    static hasMany = [owned: Course, created: Course]
    static mappedBy = [owned: 'owner', created: 'creator']
	static transients = ['springSecurityService']

	static constraints = {
		username size: 4..15, blank: false, unique: true
		firstname blank: false
		lastname blank: false
		password blank: false
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
