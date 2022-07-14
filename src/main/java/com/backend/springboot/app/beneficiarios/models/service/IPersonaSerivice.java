package com.backend.springboot.app.beneficiarios.models.service;


import com.backend.springboot.app.commons.beneficiarios.models.entity.Persona;

import java.util.List;

public interface IPersonaSerivice {

    public List<Persona> findAll();
    public Persona findById(Long id);
}
