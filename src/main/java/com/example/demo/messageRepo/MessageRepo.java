package com.example.demo.messageRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.message.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
