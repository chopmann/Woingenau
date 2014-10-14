package woingenau



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class KursController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Kurs.list(params), model:[kursInstanceCount: Kurs.count()]
    }

    def show(Kurs kursInstance) {
        respond kursInstance
    }

    def create() {
        respond new Kurs(params)
    }

    @Transactional
    def save(Kurs kursInstance) {
        if (kursInstance == null) {
            notFound()
            return
        }

        if (kursInstance.hasErrors()) {
            respond kursInstance.errors, view:'create'
            return
        }

        kursInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'kurs.label', default: 'Kurs'), kursInstance.id])
                redirect kursInstance
            }
            '*' { respond kursInstance, [status: CREATED] }
        }
    }

    def edit(Kurs kursInstance) {
        respond kursInstance
    }

    @Transactional
    def update(Kurs kursInstance) {
        if (kursInstance == null) {
            notFound()
            return
        }

        if (kursInstance.hasErrors()) {
            respond kursInstance.errors, view:'edit'
            return
        }

        kursInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Kurs.label', default: 'Kurs'), kursInstance.id])
                redirect kursInstance
            }
            '*'{ respond kursInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Kurs kursInstance) {

        if (kursInstance == null) {
            notFound()
            return
        }

        kursInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Kurs.label', default: 'Kurs'), kursInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kurs.label', default: 'Kurs'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
