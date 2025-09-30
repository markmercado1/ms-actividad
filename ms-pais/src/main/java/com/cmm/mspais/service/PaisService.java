package com.cmm.mspais.service;

import com.cmm.mspais.models.Pais;

import java.util.List;

public interface PaisService {

    Pais guardar(Pais pais);

    Pais actualizar(Long id, Pais pais);

    List<Pais> listar();

    void delete(Long id);
}
