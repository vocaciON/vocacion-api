package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
