package woingenau

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CourseController)
@Mock(User)
class CourseControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test index includes all people"() {
/*
        given:
        new Person(name: "Person", age: 22).save(flush:true)
        new Person(name: "AnotherPerson", age: 31).save(flush:true)

        when:
        request.method = 'GET'
        response.format = 'json'
        controller.index()

        then:
        response.status == 200
        response.contentAsString == '[{"class":"com.demo.Person","id":1,"age":22,"name":"Person"},{"class":"com.demo.Person","id":2,"age":31,"name":"AnotherPerson"}]'
*/
    }
}
