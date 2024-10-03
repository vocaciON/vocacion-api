package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.model.entity.Respuesta;
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

    @Transactional(readOnly = true)
    @Override
    public List<Respuesta> getAll() {

        return respuestaRepository.findAll();//obtener todos
    }
    @Transactional(readOnly = true)
    @Override
    public Respuesta findById(Long id) { //buscar
        return respuestaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Respuesta no encontrado"));

    }

    @Transactional
    @Override
    public Respuesta create(Respuesta respuesta) { //crear
        respuesta.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return respuestaRepository.save(respuesta);
    }

    @Transactional
    @Override
    public Respuesta update(Long id, Respuesta updateRespuesta) {//actualizar
        Respuesta respuestaFromDB = findById(id);






        return respuestaRepository.save(respuestaFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Respuesta respuesta = findById(id);
        respuestaRepository.delete(respuesta);

    }
}
