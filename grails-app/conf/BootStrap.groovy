import woingenau.Role
import woingenau.User
import woingenau.UserRole

class BootStrap {

  def init = { servletContext ->
    def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
    def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
    def teacher = new Role(authority: 'ROLE_TEACHER').save(flush: true)
    assert Role.count() == 3
    
    def jack = new User(username: 'jack', firstname: 'jack', lastname: 'bauer', email: 'jack@bauer.com', password: 'chucknorris')
    def joda = new User(username: 'joda', firstname: 'joda', lastname: 'maier', email: 'joda@meier.com', password: 'greenisthenewblack')
    def hans = new User(username: 'hans', firstname: 'hans', lastname: 'hodor', email: 'hans@hodor.com', password: 'hodor')
    
    jack.save(flush: true)
    joda.save(flush: true)
    hans.save(flush: true)
    assert User.count() == 3
    
    UserRole.create(jack, adminRole, true)
    UserRole.create(joda, teacher, true)
    UserRole.create(hans, userRole, true)
    assert UserRole.count() == 3
  }
  def destroy = {
  }
}
