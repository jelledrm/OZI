package com.ozi.qpid;


import org.apache.camel.component.amqp.AMQPComponent;

public class QpidConnector {


    public static void main(String[] args){
        test();
    }

    public static void test() {

        AMQPComponent amqp = AMQPComponent.amqpComponent("amqp://localhost:5672");
        System.out.println("*****AMPQ******");
        amqp.setTestConnectionOnStartup(true);
        System.out.println(amqp.getConfiguration().getClientId());
        System.out.println(amqp.getStatus().isStarted());
    }
}
