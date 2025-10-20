package com.emm.backend.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {
    @KafkaListener(groupId = "gropu-0", topics = "topic-string", containerFactory = "strContainerFactory")
    public void listener1(String message) {
        log.info("Recibiendo un message: {}", message);
        log.info("LISTENER1 ::: Recibiendo un message: {}", message);
    }

    @KafkaListener(groupId = "gropu-0", topics = "topic-string", containerFactory = "strContainerFactory")
    public void listener2(String message) {
        log.info("Recibiendo un message: {}", message);
        log.info("LISTENER2 ::: Recibiendo un message: {}", message);
    }

    @KafkaListener(groupId = "gropu-1", topics = "topic-string", containerFactory = "strContainerFactory")
    public void listener3(String message) {
        log.info("Recibiendo un message: {}", message);
        log.info("LISTENER3 ::: Recibiendo un message: {}", message);
    }

    @KafkaListener(groupId = "gropu-2", topics = "topic-string", containerFactory = "strContainerFactory")
    public void listener4(String message) {
        log.info("Recibiendo un message: {}", message);
        log.info("LISTENER4 ::: Recibiendo un message: {}", message);
    }

}
