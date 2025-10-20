package com.emm.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StringProduceService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("topic-string", message).whenComplete((res, e) -> {
            if (e != null) {

                log.error("Error al enviar el mensaje:{}",e.getMessage());

            }
            log.info("Mensaje enviado correctamente: {}",res.getProducerRecord().value());
            log.info("Particion{}, Offset {}",res.getRecordMetadata().partition(),res.getRecordMetadata().offset());
        });
    }
}
