package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.PruebaVocacional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertoRepository extends JpaRepository<PruebaVocacional, Long> {
}
