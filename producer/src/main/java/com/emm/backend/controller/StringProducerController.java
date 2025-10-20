package com.emm.backend.controller;


import com.emm.backend.service.StringProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/producer")
public class StringProducerController {


    @Autowired
    private StringProduceService stringProduceService;

    @PostMapping
    public ResponseEntity<?>sendMessage(@RequestBody String message){
        stringProduceService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
