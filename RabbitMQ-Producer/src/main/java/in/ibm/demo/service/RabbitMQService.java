package in.ibm.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.model.Item;

@Service
public class RabbitMQService {
	 @Autowired
	    private AmqpTemplate amqpTemplate;

	    private String EXCHANGE="otp-exchange";

	    private String ROUTING_KEY="items";

	    public void sendMessage(Item item) {
	        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, item);
	    }
}
