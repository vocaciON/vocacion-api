package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.RespuestaUsuarioDTO;
import com.vocaciON.vocacion_service.mapper.RespuestaUsuarioMapper;
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

    private final RespuestaUsuarioMapper respuestaUsuarioMapper;

    @Transactional(readOnly = true)
    @Override
    public List<RespuestaUsuarioDTO> getAll() {

        List<RespuestaUsuario> respuestaUsuarios = respuestaUsuarioRepository.findAll();

        return respuestaUsuarios.stream().map(respuestaUsuarioMapper::toDTO).toList();
    }


    @Transactional(readOnly = true)
    @Override
    public RespuestaUsuarioDTO findById(Long id) { //buscar
        RespuestaUsuario respuestaUsuario = respuestaUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuestas de Usuario con el id " + id + " no existe"));
        return respuestaUsuarioMapper.toDTO(respuestaUsuario);

    }

    @Transactional
    @Override
    public RespuestaUsuarioDTO create(RespuestaUsuarioDTO respuestaUsuarioDTO) { //crear

        RespuestaUsuario respuestaUsuario = respuestaUsuarioMapper.toEntity(respuestaUsuarioDTO);
        respuestaUsuario.setFechaCreate(LocalDateTime.now());
        respuestaUsuario = respuestaUsuarioRepository.save(respuestaUsuario);

        return respuestaUsuarioMapper.toDTO(respuestaUsuario);


    }

    @Transactional
    @Override
    public RespuestaUsuarioDTO update(Long id, RespuestaUsuarioDTO updateRespuestaUsuarioDTO) {//actualizar
        RespuestaUsuario respuestaUsuarioFromDB = respuestaUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La Respuesta de usuario con el id " + id + " no existe"));








        respuestaUsuarioFromDB = respuestaUsuarioRepository.save(respuestaUsuarioFromDB);
        return respuestaUsuarioMapper.toDTO(respuestaUsuarioFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        RespuestaUsuario respuestaUsuario = respuestaUsuarioRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Asesoria con el id " + id + " no existe"));
        respuestaUsuarioRepository.delete(respuestaUsuario);

    }


}
