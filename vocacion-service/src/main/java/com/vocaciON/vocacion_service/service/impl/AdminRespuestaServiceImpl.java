package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.RespuestaDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.RespuestaMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Pregunta;
import com.vocaciON.vocacion_service.model.entity.Respuesta;
import com.vocaciON.vocacion_service.repository.PreguntaRepository;
import com.vocaciON.vocacion_service.repository.RespuestaRepository;
import com.vocaciON.vocacion_service.repository.RespuestaUsuarioRepository;
import com.vocaciON.vocacion_service.service.AdminRespuestaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.time.LocalDateTime;


@Service
@Data
@RequiredArgsConstructor


public class AdminRespuestaServiceImpl implements AdminRespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final PreguntaRepository preguntaRepository;

    private final RespuestaMapper respuestaMapper;

    @Transactional(readOnly = true)
    @Override
    public List<RespuestaDTO> getAll() {

        List<Respuesta> respuestas = respuestaRepository.findAll();

        return respuestas.stream().map(respuestaMapper::toDTO).toList();
    }
    @Transactional(readOnly = true)
    @Override
    public RespuestaDTO findById(Long id) { //buscar
        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Respuesta con el id " + id + " no existe"));
        return respuestaMapper.toDTO(respuesta);

    }

    @Transactional
    @Override
    public RespuestaDTO create(RespuestaDTO respuestaDTO) { //crear

        Respuesta respuesta = respuestaMapper.toEntity(respuestaDTO);
        respuesta.setFechaCreate(LocalDateTime.now());
        respuesta = respuestaRepository.save(respuesta);

        return respuestaMapper.toDTO(respuesta);
    }

    @Transactional
    @Override
    public RespuestaDTO update(Long id, RespuestaDTO updateRespuestaDTO) {//actualizar
        Respuesta respuestaFromDB = respuestaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La Respuesta con el id " + id + " no existe"));



        respuestaFromDB.setDescripcion(updateRespuestaDTO.getDescripcion());


        respuestaFromDB = respuestaRepository.save(respuestaFromDB);
        return respuestaMapper.toDTO(respuestaFromDB);


    }

    @Transactional
    @Override
    public void delete(Long id) {
        Respuesta respuesta = respuestaRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Respuesta con el id " + id + " no existe"));
        respuestaRepository.delete(respuesta);

    }
}
