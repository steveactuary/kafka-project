package com.example.demo.kafkaController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.message.Message;
import com.example.demo.messageRepo.MessageRepo;

@RestController
public class KafkaController {

   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;
   
   @Autowired
   private MessageRepo repo;

   
   @PostMapping("/send")
   public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
       // do something with the message
	   kafkaTemplate.send("my-topic", message);
       return ResponseEntity.ok("Message sent: " + message);
   }
 
   @GetMapping("/messages")
   public ResponseEntity<List<Message>> getAllMessages() {
	   List<Message> messages = repo.findAll();
	   
       return new ResponseEntity<>(messages, HttpStatus.OK);
   }
}
