package woingenau
import grails.plugin.springsecurity.annotation.Secured

class HomeController {
	def springSecurityService
	@Secured(['ROLE_ADMIN'])
    def index() { 
		def user = springSecurityService.currentUser
		def roles = user.getAuthorities()
		
		render "Hallo ${user.username}. Deine Authority ist: ${roles[0].authority}"
	}
}
