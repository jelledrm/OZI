package com.ozi;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OZIApplication {

	public static void main(String[] args) {
		SpringApplication.run(OZIApplication.class, args);
	}

	@Bean
	public AMQPConnectionDetails amqpConnection() {
		return new AMQPConnectionDetails("amqp://lcoalhost:5672");
	}
}
