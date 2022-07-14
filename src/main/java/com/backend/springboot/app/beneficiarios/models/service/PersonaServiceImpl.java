package com.backend.springboot.app.beneficiarios.models.service;

import com.backend.springboot.app.beneficiarios.models.repository.PersonaRepository;
import com.backend.springboot.app.commons.beneficiarios.models.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaSerivice{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return personaRepository.findById( id ).orElse(null);
    }
}
