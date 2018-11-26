package club.cheapok.jmsAsync;

import java.util.concurrent.CountDownLatch;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;

public class AsyncClientReceiver {
        private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws JMSException, InterruptedException {
        AsyncClientReceiver asyncClientReceiver = new AsyncClientReceiver();

        asyncClientReceiver.receiveMessages();
    }

    private  void receiveMessages() throws JMSException, InterruptedException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        final Connection connection = connectionFactory.createConnection();
        final Session session = connection.createSession(false, 1);

        final Queue queue = session.createQueue("customerQueue");
        final MessageConsumer consumer = session.createConsumer(queue);
        MyMessageListener myListener = new MyMessageListener("IakaListener", this);
        consumer.setMessageListener(myListener);

        //provide access to latch
        connection.start();
        latch.await();


    }

    public void latchCountDown() {
        latch.countDown();
    }


}
