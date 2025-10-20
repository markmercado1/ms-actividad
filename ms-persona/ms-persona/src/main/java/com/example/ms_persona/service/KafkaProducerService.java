package com.example.ms_persona.service;

import com.example.ms_persona.events.PersonaCreadaEvent;

public interface KafkaProducerService {
    void enviarPersonaCreada(PersonaCreadaEvent event);
}
