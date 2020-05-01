package in.ibm.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import in.ibm.demo.model.Item;

@Service
public class RabbitMqConsumerService {
	private static final String QUEUE = "items-queue";

	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Item item) {

		System.out.println("Received Message from Items Queue >>" + item);

	}
}
