package com.sam.mongo.routes;

import com.sam.mongo.model.Person;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder  extends ExceptionRouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("restlet")
                .apiContextRouteId("service1")
                .bindingMode(RestBindingMode.auto)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Example of REST API").apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
//                .host("localhost").port("8888")
                ;

        rest("/person").id("rest-person")
                // "/person" or "/person?firstName=First" or "/person?lastName=Last"
                .get("").id("rest-person-get").consumes("application/json").produces("application/json").to("direct:getAllPerson")
                // "/person/id"
                .get("/{id}").id("rest-person-get-id").consumes("application/json").produces("application/json").to("direct:getSinglePerson")
                .post("").id("rest-person-post").consumes("application/json").produces("application/json").type(Person.class).to("direct:postPerson");

    }
}
