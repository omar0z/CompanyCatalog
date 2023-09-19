package com.pluralsight.catalog;

import java.io.*;
import java.net.URL;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // // Ejemplo 1: opción sencilla con tipos de datos básicos (String)
        // // servicio web WebServiceInterface (servidor)
        // URL url = new URL("http://localhost:8080/company-catalog/WebServiceImplService?wsdl");
        // QName qname = new QName("http://wsapp.example.com/", "WebServiceImplService");
        // Service service = Service.create(url, qname);
        // // cliente del servicio web
        // // EmployeeService helloService = service.getPort(EmployeeService.class);
        // // System.out.println(helloService.helloWorld("Alan"));

        // // Ejemplo 2: opción avanzada con tipos definidos por el usuario (Person)
        // url = new URL("http://localhost:8080/company-catalog/PersonServiceImplService?wsdl");
        // qname = new QName("http://wsapp.example.com/", "PersonServiceImplService");
        // service = Service.create(url, qname);
        // // cliente del servicio web
        // PersonService personService = service.getPort(PersonService.class);
        // System.out.println(personService.findAll());
        // System.out.println(personService.findById(1L));
        // System.out.println(personService.save(new Company(4L, "person4", 30)));
        // System.out.println(personService.findAll());


        // response.setContentType("text/html");

        // // Hello
        // PrintWriter out = response.getWriter();
        // out.println("<html><body>");
        // out.println("<h1>" + message + "</h1>");
        // out.println("</body></html>");
    }

    public void destroy() {
    }
}