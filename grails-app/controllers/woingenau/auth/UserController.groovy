package woingenau.auth

import grails.converters.JSON
import grails.transaction.Transactional
import static org.springframework.http.HttpStatus.*

@Transactional()
class UserController {
    def springSecurityService
    static responseFormats = ['json', 'xml']


    def index(Integer max) {
        log.debug(springSecurityService.principal)
        JSON.use('thin')
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), [status: OK]
    }

    def show(User userInstance) {
        JSON.use('thin')
        log.debug(userInstance.password)
        respond userInstance, [status: OK]
    }

    def save() {
        JSON.use('thin')
        def userData = request.JSON
        def userInstance = new User(firstname: userData.firstname,
                lastname: userData.lastname,
                username: userData.username,
                password: userData.password,
                email: userData.email,
                enabled: true)
        userInstance.validate()
        if (userInstance.hasErrors()) {
            log.debug(userInstance.errors)
            render status: NOT_ACCEPTABLE
        } else {
            userInstance.save(flush: true)

            respond userInstance, [status: CREATED]
        }
    }

    def update(User userInstance) {
        def userData = request.JSON
        if (userInstance == null) {
            render status: NOT_FOUND
            return
        }
        userData.each {
            prop, val ->
                if (prop in User.updatableProperties) {
                    userInstance[prop] = val
                }
        }
        userInstance.validate()
        if (userInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        JSON.use('thin')
        userInstance.save flush: true
        respond userInstance, [status: OK]
    }

    def delete() {}
}
