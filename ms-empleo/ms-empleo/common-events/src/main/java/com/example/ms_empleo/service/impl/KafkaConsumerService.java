package com.example.ms_empleo.service.impl;




import com.example.ms_empleo.dto.PersonaCreadaEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "personas-topic", groupId = "empleo-group")
    public void consumePersonaCreada(PersonaCreadaEvent event) {
        log.info("Evento recibido - Persona creada: {}", event);

        // Aquí puedes procesar el evento según tus necesidades
        // Por ejemplo: guardar en base de datos, enviar notificación, etc.

        System.out.println("=== EVENTO PERSONA CREADA RECIBIDO ===");
        System.out.println("ID Persona: " + event.getIdPersona());
        System.out.println("Nombre: " + event.getNombre());
        System.out.println("DNI: " + event.getDni());
        System.out.println("=====================================");

        // Ejemplo de lógica de negocio:
        procesarPersonaParaEmpleo(event);
    }

    private void procesarPersonaParaEmpleo(PersonaCreadaEvent event) {
        // Aquí implementas la lógica específica de tu microservicio empleo
        // Por ejemplo:
        // - Crear un perfil de empleo automáticamente
        // - Asignar habilidades por defecto
        // - Notificar a reclutadores
        // - etc.

        log.info("Procesando persona {} para módulo de empleo", event.getNombre());
    }
}