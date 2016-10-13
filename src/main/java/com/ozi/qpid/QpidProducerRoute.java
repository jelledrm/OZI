package com.ozi.qpid;


import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.SimpleBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class QpidProducerRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        restConfiguration().component("servlet")
                .port(8080);

        rest("/")
                .get("/hello").to("direct:hello");


        from("direct:hello")
                .setBody(new SimpleBuilder("HELLO FROM THE OTHER SIDE"))
                .to(ExchangePattern.InOnly,"amqp:queue:test");


               /*
                .setBody(new SimpleBuilder("HELLO FROM THE OTHER SIDE"))
                .to("amqp:queue:test");*/

    }

}
