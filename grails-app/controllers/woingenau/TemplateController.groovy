package woingenau



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TemplateController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Template.list(params), [status: OK]
    }

    @Transactional
    def save(Template templateInstance) {
        if (templateInstance == null) {
            render status: NOT_FOUND
            return
        }

        templateInstance.validate()
        if (templateInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        templateInstance.save flush:true
        respond templateInstance, [status: CREATED]
    }

    @Transactional
    def update(Template templateInstance) {
        if (templateInstance == null) {
            render status: NOT_FOUND
            return
        }

        templateInstance.validate()
        if (templateInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        templateInstance.save flush:true
        respond templateInstance, [status: OK]
    }

    @Transactional
    def delete(Template templateInstance) {

        if (templateInstance == null) {
            render status: NOT_FOUND
            return
        }

        templateInstance.delete flush:true
        render status: NO_CONTENT
    }
}
