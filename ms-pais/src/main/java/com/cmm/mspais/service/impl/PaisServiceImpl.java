package com.cmm.mspais.service.impl;

import com.cmm.mspais.models.Pais;
import com.cmm.mspais.repository.PaisRepository;
import com.cmm.mspais.service.PaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    @Override
    public Pais guardar(Pais pais) {

        return paisRepository.save(pais);
    }

    @Override
    public Pais actualizar(Long id, Pais pais) {

        return paisRepository.findById(id).map(existing -> {
            existing.setNombre(pais.getNombre());
            return paisRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Empleo no encontrado con id " + id));
    }

    @Override
    public List<Pais> listar() {
        return paisRepository.findAll();
    }

    @Override
    public void delete(Long id) {

        paisRepository.deleteById(id);

    }
}
