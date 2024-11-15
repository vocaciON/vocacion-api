package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.AsesoriaCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ExpertoCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ExpertoDTO;

import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;

import com.vocaciON.vocacion_service.mapper.ExpertoMapper;

import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Experto;

import com.vocaciON.vocacion_service.repository.ExpertoRepository;
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
                .orElseThrow(() -> new ResourceNotFoundException("Experto con el id " + id + " no existe"));
        return expertoMapper.toDTO(experto);

    }

    @Transactional
    @Override
    public ExpertoDTO create(ExpertoCreateUpdateDTO expertoCreateUpdateDTO) {


        Experto experto = expertoMapper.toEntity(expertoCreateUpdateDTO);

        experto.setFechaCreate(LocalDateTime.now());

        return expertoMapper.toDTO(expertoRepository.save(experto));
    }

    @Transactional
    @Override
    public ExpertoDTO update(Long id, ExpertoCreateUpdateDTO updateExpertoDTO) {
        // Buscar asesoria en la base de datos por su ID
        Experto expertoFromDB = expertoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El experto con el id " + id + " no existe"));


        expertoFromDB.setInformacionPersonal(updateExpertoDTO.getInformacionPersonal());
        expertoFromDB.setEspecialidad(updateExpertoDTO.getEspecialidad());


        expertoFromDB.setFechaUpdate(LocalDateTime.now()); // Actualizar la fecha de actualización


        // Guardar el perfil actualizado
        expertoRepository.save(expertoFromDB);

        // Convertir la entidad actualizada a DTO y devolverla
        return expertoMapper.toDTO(expertoFromDB);

    }

    @Transactional
    @Override
    public void delete(Long id) {
        Experto experto = expertoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El experto con id " + id + " no existe"));

    }

}
