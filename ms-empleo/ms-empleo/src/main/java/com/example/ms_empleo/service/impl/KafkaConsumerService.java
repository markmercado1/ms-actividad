package com.example.ms_empleo.service.impl;




import com.example.ms_empleo.events.PersonaCreadaEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "personas-topic",
            groupId = "persona-consumer-group"
    )
    public void consumirPersonaCreada(PersonaCreadaEvent event) {
        log.info("========================================");
        log.info("Evento recibido desde Kafka:");
        log.info("ID Persona: {}", event.getIdPersona());
        log.info("Nombre: {}", event.getNombre());
        log.info("DNI: {}", event.getDni());
        log.info("========================================");

        // Aquí puedes hacer lo que necesites con el evento
        // Por ejemplo: guardar en otra BD, enviar notificación, etc.
        procesarPersona(event);
    }

    private void procesarPersona(PersonaCreadaEvent event) {
        // Tu lógica de negocio aquí
        // Ejemplo: guardar en otra tabla, enviar email, etc.
    }
}