import woingenau.Template
import woingenau.auth.Role
import woingenau.auth.User
import woingenau.auth.UserRole
import woingenau.Course
import woingenau.Appointment
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(Appointment) { Appointment appointment ->
            [
                    id: appointment.id,
                    place: appointment.place,
                    start: appointment.start,
                    end: appointment.end,
            ]
        }

        JSON.createNamedConfig('thin') {
            it.registerObjectMarshaller( User ) { User user ->
                return [
                        id: user.id,
                        username: user.username,
                        firstname: user.firstname,
                        lastname: user.lastname,
                        enabled: user.enabled
                ]
            }
        }

        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        def teacher = new Role(authority: 'ROLE_TEACHER').save(flush: true)
        assert Role.count() == 3
        def course = new Course(title:'The Force 101')
        def jack = new User(username: 'jack', firstname: 'jack', lastname: 'bauer', email: 'jack@bauer.com', password: 'chucknorris')
        def joda = new User(username: 'joda', firstname: 'joda', lastname: 'maier', email: 'joda@meier.com', password: 'greenisthenewblack')
        def hans = new User(username: 'hans', firstname: 'hans', lastname: 'hodor', email: 'hans@hodor.com', password: 'hodor')
        course.creator = jack
        course.lecturer = joda

        def appointment = new Appointment(place: "Empire", start: new Date(), end: new Date() )
        def users = [jack, joda, hans]
        course.members = users
        course.addToAppointments(appointment)
        course.save()
        jack.save(flush: true)
        joda.save(flush: true)
        hans.save(flush: true)
        appointment.save()
        assert User.count() == 3

        UserRole.create(jack, adminRole, true)
        UserRole.create(joda, teacher, true)
        UserRole.create(hans, userRole, true)
        assert UserRole.count() == 3

        assert Course.count() == 1
        assert course.members.size() == 3
        def template1 = new Template(name: 'The Lightside', semester: 'WS15', major: 'Software Entwicklung', faculty: 'Informatik')
        def template2 = new Template(name: 'The Darkside', semester: 'SS15', major: 'Software Entwicklung', faculty: 'Informatik')
        template1.addToCourses(course)
        template2.addToCourses(course)
        template1.creator = jack
        template2.creator = jack
        template1.save(flush: true)
        template2.save(flush: true)
        assert Template.count() == 2
    }
    def destroy = {
    }
}
