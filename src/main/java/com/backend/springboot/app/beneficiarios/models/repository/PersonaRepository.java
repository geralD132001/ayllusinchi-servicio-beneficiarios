package com.backend.springboot.app.beneficiarios.models.repository;

import com.backend.springboot.app.commons.beneficiarios.models.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {


}
