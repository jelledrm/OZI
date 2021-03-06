package com.ozi.config;

import org.apache.camel.component.amqp.AMQPComponent;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.qpid.client.AMQConnectionFactory;
import org.apache.qpid.url.URLSyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("com.ozi.*")
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class OZIApplication {

    public static void main(String[] args) {
        SpringApplication.run(OZIApplication.class, args);
    }

//    private static final String CAMEL_URL_MAPPING = "/say/*";
//    private static final String CAMEL_SERVLET_NAME = "CamelServlet";
//
//    @Bean
//    public ServletRegistrationBean camelServletRegistration() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), CAMEL_URL_MAPPING);
//        registration.setName(CAMEL_SERVLET_NAME);
//        return registration;
//    }

    @Bean
    public ServletRegistrationBean camelServletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CXFServlet(),"/*");
        registrationBean.setName("CXFServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public AMQConnectionFactory amqConnectionFactory() throws URLSyntaxException {
        return new AMQConnectionFactory("amqp://guest:guest@clientid/?brokerlist='tcp://localhost:5672'");
    }

    @Bean
    public AMQPComponent amqpComponent() throws URLSyntaxException {
        return new AMQPComponent(amqConnectionFactory());
    }

}
