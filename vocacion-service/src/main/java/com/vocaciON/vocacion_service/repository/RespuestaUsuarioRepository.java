package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.Respuesta;
import com.vocaciON.vocacion_service.model.entity.RespuestaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaUsuarioRepository extends JpaRepository<RespuestaUsuario, Long> {
}
