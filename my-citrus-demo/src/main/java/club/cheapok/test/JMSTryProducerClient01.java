package club.cheapok.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSTryProducerClient01 {

    private static final String payload = "Cucu  Madalina :)";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
            "tcp://localhost:61616");
        final Connection connection = connectionFactory.createConnection();
        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//1
        Queue queue = session.createQueue("customerQueue");

        MessageProducer producer = session.createProducer(queue);

        Message msg = session.createTextMessage(payload);
        producer.send(msg);

        producer.send(session.createTextMessage("END"));


        try {
            session.close();
        } finally {
            connection.close();
        }


    }

}
