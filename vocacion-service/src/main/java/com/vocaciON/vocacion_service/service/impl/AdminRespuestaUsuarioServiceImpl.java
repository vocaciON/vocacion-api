package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.RespuestaUsuario;
import com.vocaciON.vocacion_service.repository.PreguntaRepository;
import com.vocaciON.vocacion_service.repository.RespuestaRepository;
import com.vocaciON.vocacion_service.repository.RespuestaUsuarioRepository;
import com.vocaciON.vocacion_service.repository.ResultadoPruebaRepository;
import com.vocaciON.vocacion_service.service.AdminRespuestaUsuarioService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor

public class AdminRespuestaUsuarioServiceImpl implements AdminRespuestaUsuarioService {

    private final RespuestaUsuarioRepository respuestaUsuarioRepository;
    private final ResultadoPruebaRepository resultadoPruebaRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;

    @Transactional(readOnly = true)
    @Override
        public List<RespuestaUsuario> getAll() {
        return respuestaUsuarioRepository.findAll();//obtener todos
    }
    @Transactional(readOnly = true)
    @Override
    public RespuestaUsuario findById(Long id) { //buscar
        return respuestaUsuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Respuesta Usuario  no encontrado"));

    }

    @Transactional
    @Override
    public RespuestaUsuario create(RespuestaUsuario respuestaUsuario) { //crear
        respuestaUsuario.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return respuestaUsuarioRepository.save(respuestaUsuario);
    }

    @Transactional
    @Override
    public RespuestaUsuario update(Long id, RespuestaUsuario updateRespuestaUsuario) {//actualizar
        RespuestaUsuario respuestaUsuarioFromDB = findById(id);








        return respuestaUsuarioRepository.save(respuestaUsuarioFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        RespuestaUsuario respuestaUsuario = findById(id);
        respuestaUsuarioRepository.delete(respuestaUsuario);

    }


}
