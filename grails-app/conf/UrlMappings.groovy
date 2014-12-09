import static org.codehaus.groovy.grails.web.mapping.DefaultUrlMappingEvaluator.*
class UrlMappings {

	static mappings = {

  //      "/appointments"(resources: "appointment")
        "/courses"(resources:"course" ) {
            "/appointments"(resources:"appointment")
            "/members"(controller:"member", action: 'index', method: 'GET')
            "/members"(controller:"member", action: 'save', method: 'POST')
            "/members"(controller:"member", action: 'delete', method: 'DELETE')
        }


        "/templates"(resources:"template")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
