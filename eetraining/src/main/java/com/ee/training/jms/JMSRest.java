package com.ee.training.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/jms")
public class JMSRest {

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "java:/jms/queue/MyJMSQueue")
    private Queue      queue;

    @Resource(lookup = "java:/jms/queue/MyJMSTopic")
    private Topic      topic;

    @Path("/queue")
    @GET
    public void sendQueue(@QueryParam("msg") final String msg) {
        this.jmsContext.createProducer()
                       .send(this.queue,
                             msg);
    }

    @Path("/topic")
    @GET
    public void sendTopic(@QueryParam("msg") final String msg) {
        this.jmsContext.createProducer()
                       .send(this.topic,
                             msg);

    }

}
