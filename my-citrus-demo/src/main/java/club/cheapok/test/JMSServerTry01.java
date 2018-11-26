package club.cheapok.test;

import java.net.URI;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class JMSServerTry01 {

    public static void main(String[] args) throws Exception {

        BrokerService broker = BrokerFactory.createBroker(new URI(
            "broker:(tcp://localhost:61616)"));
        broker.start();

    }

}
