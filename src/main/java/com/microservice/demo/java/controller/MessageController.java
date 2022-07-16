package com.microservice.demo.java.controller;

import com.microservice.demo.java.entity.Message;
import com.microservice.demo.java.service.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    private final IMessageService messageService;

    @PostMapping("/message")
    String validateMessage(@RequestBody Message message){
        return messageService.validateIsGroseria(message.getDescription());
    }

}
