package club.cheapok.jmsAsync;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

    private final String consumerName;
    private final AsyncClientReceiver asyncClientReceiver;

    public MyMessageListener(String consumerName, AsyncClientReceiver asyncClientReceiver) {
        this.consumerName = consumerName;
        this.asyncClientReceiver = asyncClientReceiver;
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("Consumer:" + consumerName+ " has received: "+ message);
            final String text = textMessage.getText();
            System.out.println("Message: " + text);
            if (text.equals("END")) {
                asyncClientReceiver.latchCountDown();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
