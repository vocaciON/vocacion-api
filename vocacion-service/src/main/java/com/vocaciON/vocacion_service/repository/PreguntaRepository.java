package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
