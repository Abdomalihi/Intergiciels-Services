package jmsTIW;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class Producer {
    public static void main(String[] args) {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
           // Destination destination = session.createQueue("iga.queue");
            Destination destination = session.createTopic("iga.topic");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("Hello .........");
            producer.send(textMessage);
            System.out.println("Envoi du message");
            session.close();
            connection.close();
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
