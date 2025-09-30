package com.example.ms_empleo.feign;


import com.example.ms_empleo.dto.PaisDto;
import com.example.ms_empleo.dto.PersonaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-pais",path = "/pais")
public interface PaisFeign {


    @GetMapping("/{id}")
    @CircuitBreaker(name = "paisListarPorIdCB", fallbackMethod = "fallBackPais")
    ResponseEntity<PaisDto> buscarPorId(@PathVariable Long id);
    default ResponseEntity<PaisDto> fallBackPais(Long id, Exception e) {
        PaisDto paisDto = new PaisDto();
        paisDto.setIdPais(9000000L);
        paisDto.setNombre("Servicio Pais fallido");
        return ResponseEntity.ok(paisDto);
    }

}
