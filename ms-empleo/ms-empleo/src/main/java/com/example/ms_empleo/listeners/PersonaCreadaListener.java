package com.example.ms_empleo.listeners;

import com.example.ms_empleo.dto.PersonaDto;
import com.example.ms_empleo.service.IEmpleoService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonaCreadaListener {

    private final IEmpleoService empleoService;

    @KafkaListener(topics = "personas-topic", groupId = "empleo-group")
    public void escucharPersonaCreada(PersonaDto event) {
        System.out.println("📥 Evento recibido en ms-empleo: " + event);
        empleoService.crearPerfilVacio(event.getIdPersona(), event.getNombre(), event.getDni());
    }
}

