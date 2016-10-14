package com.ozi.qpid;


import com.ozi.api.OziApi;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class QpidProducerRoute extends RouteBuilder {

    private final String uri = "cxf:/ozi?serviceClass=" + OziApi.class.getName();

    @Override
    public void configure() throws Exception {

        from(uri)
            .to("log:input")
        .recipientList(simple("direct:${header.operationName}"));


        from("direct:store")
            .process(exchange -> {
                String data = exchange.getIn().getBody(String.class);
                exchange.getIn().setBody(data);
                exchange.getOut().setBody("Thanks for the message; your document will be created soon!!");
            })
        .to(ExchangePattern.InOnly,"amqp:queue:test");


//        restConfiguration().component("servlet").port(8080);
//
//        rest("/")
//                .get("/hello")
//        .to("direct:hello");
//
//
//        from("direct:hello")
//                .setBody(new SimpleBuilder("HELLO FROM THE OTHER SIDE"))
//        .to(ExchangePattern.InOut,"amqp:queue:test");


               /*
                .setBody(new SimpleBuilder("HELLO FROM THE OTHER SIDE"))
                .to("amqp:queue:test");*/

    }

}
