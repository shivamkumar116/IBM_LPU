package in.ibm.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ibm.demo.entity.Account;

@Service
public class AccountService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	private String EXCHANGE = "account-exchange";

	private String ROUTING_KEY = "accounts";

	public void sendMessage(Account item) {
		amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, item);
	}
}
