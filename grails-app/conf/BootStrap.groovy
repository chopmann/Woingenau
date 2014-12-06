import woingenau.Role
import woingenau.User
import woingenau.UserRole
import woingenau.Course
import woingenau.Appointment

class BootStrap {

    def init = { servletContext ->
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
    }
    def destroy = {
    }
}
