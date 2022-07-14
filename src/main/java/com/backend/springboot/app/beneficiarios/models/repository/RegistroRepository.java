package com.backend.springboot.app.beneficiarios.models.repository;

import com.backend.springboot.app.commons.beneficiarios.models.entity.Registro;
import org.springframework.data.repository.CrudRepository;

public interface RegistroRepository extends CrudRepository<Registro, Long> {

}
