package com.sam.mongo.routes;

import com.sam.mongo.configuration.MongoConfig;
import com.sam.mongo.model.Person;
import org.apache.camel.LoggingLevel;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder  extends ExceptionRouteBuilder {

    @Autowired
    MongoConfig myDb;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("restlet")
                .apiContextRouteId("service1")
                .bindingMode(RestBindingMode.auto)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Example of REST API").apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .host("localhost").port("8888")
                ;

        rest("/employee")
                .post().to("direct:postEmployees")
                .get().to("direct:getEmployees").description("All Employees list")
                /*.get("/{empId}").to("direct:getEmployeeId").description("Find Employee by Id")
                .put("/{empId}").to("direct:putEmpId").description("Modify Emp by ID")
                .delete("/{empId}").to("direct:deleteEmployeeId").description("Delete emp by Id")*/
        ;

        from("direct:getEmployees")
                .to("mongodb:myDb?database=test&collection=customer&operation=findAll")
                .log(LoggingLevel.INFO, "${body}")
        ;

        from("direct:postEmployees")
                .to("mongodb:myDb?database=test&collection=customer&operation=insert")
                .log(LoggingLevel.INFO, "${body}")
        ;

       /*
        from("direct:getEmployeeId")
                .setBody(simple("select * from employee where id = ${header.empId}"))
                .to("jdbc:dataSource")
        ;

        from("direct:putEmpId")
                .setBody(simple("update employee set department='${body[department]}', employee_name='${body[employee_name]}'," +
                        "employee_salary = ${body[salary]} where id = ${header.empId}"))
                .to("jdbc:dataSource")
        ;

        from("direct:deleteEmployeeId")
                .setBody(simple("delete from employee where id = ${header.empId}"))
                .to("jdbc:dataSource")
        ;*/



    }
}
