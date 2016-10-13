package qpiddemo;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class HelloWorldDemo {

	public HelloWorldDemo() {
	}

	public static void main(String[] args) throws Exception {
		HelloWorldDemo helloWorldDemo = new HelloWorldDemo();
		helloWorldDemo.runTest();
	}

	private void runTest() throws Exception {
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("helloworld.properties"));
		Context context = new InitialContext(properties);

		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("qpidConnectionFactory");
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
		Queue queue = (Queue) context.lookup("myqueue");

		MessageConsumer messageConsumer = session.createConsumer(queue);
		MessageProducer messageProducer = session.createProducer(queue);

		TextMessage message = session.createTextMessage("HelloWorldDemo world!");
		messageProducer.send(message);
		session.commit();

		message = (TextMessage)messageConsumer.receive();
		session.commit();
		System.out.println(message.getText());

		connection.close();
		context.close();
	}
}