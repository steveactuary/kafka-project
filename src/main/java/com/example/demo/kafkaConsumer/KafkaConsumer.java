package com.example.demo.kafkaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.message.Message;
import com.example.demo.messageRepo.MessageRepo;

@Component
public class KafkaConsumer {
	
	@Autowired
	private MessageRepo repo;

    @KafkaListener(topics = "my-topic", groupId = "my-first-group")
    public void consume(String message){
    	Message msg = new Message();
    	msg.setBody(message);
    	repo.save(msg);
        System.out.println("message = " + message);
    }
}
