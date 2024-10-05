package com.vocaciON.vocacion_service.service.impl;
// Estas clases van a contener la implementacion

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.ExpertoDTO;
import com.vocaciON.vocacion_service.mapper.ExpertoMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.repository.ExpertoRepository;
import com.vocaciON.vocacion_service.repository.UsuarioRepository;
import com.vocaciON.vocacion_service.service.AdminExpertoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminExpertoServiceImpl implements AdminExpertoService {

    private final ExpertoRepository expertoRepository;
    private final UsuarioRepository usuarioRepository;

    private final ExpertoMapper expertoMapper;


    @Transactional(readOnly = true)
    @Override
    public List<ExpertoDTO> getAll() {

        List<Experto> expertos = expertoRepository.findAll();

        return expertos.stream().map(expertoMapper::toDTO).toList();
    }
    @Transactional(readOnly = true)
    @Override
    public ExpertoDTO findById(Long id) { //buscar
        Experto experto = expertoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experto con el id " + id + " no existe"));
        return expertoMapper.toDTO(experto);

    }

    @Transactional
    @Override
    public ExpertoDTO create(ExpertoDTO expertoDTO) { //crear

        Experto experto = expertoMapper.toEntity(expertoDTO);
        experto.setFechaCreate(LocalDateTime.now());
        experto = expertoRepository.save(experto);

        return expertoMapper.toDTO(experto);
    }

    @Transactional
    @Override
    public ExpertoDTO update(Long id, ExpertoDTO updateExpertoDTO) {//actualizar
        Experto expertoFromDB = expertoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Experto con el id " + id + " no existe"));

        /*Usuario usuario = usuarioRepository.findById(updateExperto.getUsuario().getId())
                        .orElseThrow(() -> new RuntimeException("Usuario  no encontrado"+updateExperto.getUsuario().getId()));*/

        expertoFromDB.setInformacionPersonal(updateExpertoDTO.getInformacionPersonal());

        expertoFromDB.setEstudios(updateExpertoDTO.getEstudios());
        expertoFromDB.setEspecialidad(updateExpertoDTO.getEspecialidad());



        /*expertoFromDB.setUsuario(usuario);*/

        expertoFromDB = expertoRepository.save(expertoFromDB);
        return expertoMapper.toDTO(expertoFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Experto experto = expertoRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Experto con el id " + id + " no existe"));
        expertoRepository.delete(experto);

    }
}
