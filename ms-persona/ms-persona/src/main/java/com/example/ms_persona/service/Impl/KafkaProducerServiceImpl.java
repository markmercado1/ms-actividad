package com.example.ms_persona.service.Impl;

import com.example.ms_persona.events.PersonaCreadaEvent;
import com.example.ms_persona.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "personas-topic";

    @Override
    public void enviarPersonaCreada(PersonaCreadaEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Evento persona.creada enviado: " + event);
    }
}
