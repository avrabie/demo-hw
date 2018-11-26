package club.cheapok.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JSMConsumerClient01 {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
            "tcp://localhost:61616");
        final Connection connection = connectionFactory.createConnection();
        final Session session = connection.createSession(false, 1);

        Queue queue = session.createQueue("customerQueue");
        MessageConsumer consumer = session.createConsumer(queue);
        connection.start();

        TextMessage textMsg = (TextMessage) consumer.receive(); //probably blocking
        System.out.println(textMsg);
        System.out.println("Text message received: "+textMsg.getText());

        session.close();
        connection.close();
    }
}
