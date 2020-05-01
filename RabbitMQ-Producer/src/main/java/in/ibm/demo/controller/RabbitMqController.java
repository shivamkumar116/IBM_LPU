package in.ibm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ibm.demo.model.Item;
import in.ibm.demo.service.RabbitMQService;

@RestController
public class RabbitMqController {

	 @Autowired
	    RabbitMQService rabbitMqService;

	    @PostMapping("/items")
	    public ResponseEntity<String> postMessage(@RequestBody Item item){
	        rabbitMqService.sendMessage(item);
	        return new ResponseEntity<String>("Item pushed to RabbitMQ",HttpStatus.CREATED);
	    }
}
