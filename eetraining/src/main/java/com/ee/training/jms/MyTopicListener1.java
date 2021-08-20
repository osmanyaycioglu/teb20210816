package com.ee.training.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Topic"),
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "MyJMSTopic")
})
public class MyTopicListener1 implements MessageListener {

    public MyTopicListener1() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage messageLoc = (TextMessage) message;
            try {
                System.out.println("Topic Consumer 1 received message :" + messageLoc.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Topic Consumer 1 received message :" + message);
    }

}
