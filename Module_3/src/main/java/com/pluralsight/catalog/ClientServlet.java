package com.pluralsight.catalog;

import java.io.*;
import java.net.URL;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;

import com.pluralsight.catalog.document.CompanyService;

@WebServlet(name = "clientServlet", value = "/client-servlet")
public class ClientServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        
        // URL url = new URL("http://localhost:8080/company-catalog/WebServiceImplService?wsdl");
        // QName qname = new QName("http://wsapp.example.com/", "WebServiceImplService");
        // Service service = Service.create(url, qname);
        // EmployeeService helloService = service.getPort(EmployeeService.class);
        // System.out.println(helloService.helloWorld("Alan"));

        // We get the service definition from the Application Server
        URL url = new URL("http://localhost:8080/company-catalog/CompanyServiceImplService?wsdl");
        QName qname = new QName("http://document.catalog.pluralsight.com/", "CompanyServiceImplService");
        //We create a Service instance
        Service service = Service.create(url, qname);
        CompanyService personService = service.getPort(CompanyService.class);
        //Then we proceed to invoke the service desired operation.
        System.out.println(personService.findAll());
    }

    public void destroy() {
    }
}