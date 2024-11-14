package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidoEducativoRepository extends JpaRepository<ContenidoEducativo, Long> {

    List<ContenidoEducativo> findTop6ByOrderByCreatedAtDesc();
}
