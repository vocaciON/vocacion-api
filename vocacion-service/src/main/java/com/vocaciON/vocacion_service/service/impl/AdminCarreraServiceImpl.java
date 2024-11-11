package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.dto.CarreraDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.AsesoriaMapper;
import com.vocaciON.vocacion_service.mapper.CarreraMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Carrera;
import com.vocaciON.vocacion_service.repository.AsesoriaRepository;
import com.vocaciON.vocacion_service.repository.CarreraRepository;
import com.vocaciON.vocacion_service.service.AdminCarreraService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class AdminCarreraServiceImpl implements AdminCarreraService {
    private final CarreraRepository carreraRepository;
    private final CarreraMapper carreraMapper;
    private final AsesoriaMapper asesoriaMapper;
    private final AsesoriaRepository asesoriaRepository;

    @Transactional(readOnly = true)
    @Override

    public List<CarreraDTO> getAll() {
        List<Carrera> carreras = carreraRepository.findAll();

        return carreras.stream().map(carreraMapper::toDTO).toList();


    }
    @Transactional(readOnly = true)
    @Override
    public CarreraDTO findById(Long id) { //buscar
        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera con el id " + id + " no existe"));
        return carreraMapper.toDTO(carrera);

    }

    @Transactional
    @Override
    public CarreraDTO create(CarreraDTO carreraDTO) { //crear
        Carrera carrera = carreraMapper.toEntity(carreraDTO);
        carrera.setFechaCreate(LocalDateTime.now());
        carrera = carreraRepository.save(carrera);

        return carreraMapper.toDTO(carrera);
    }

    @Transactional
    @Override
    public CarreraDTO update(Long id, CarreraDTO updateCarreraDTO) {//actualizar
        Carrera carreraFromDB = carreraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La carrera con el id " + id + " no existe"));

        carreraFromDB.setNombre(updateCarreraDTO.getNombre());
        carreraFromDB.setDescripcion(updateCarreraDTO.getDescripcion());




        carreraFromDB = carreraRepository.save(carreraFromDB);
        return carreraMapper.toDTO(carreraFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Carrera carrera = carreraRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Carrera con el id " + id + " no existe"));
        carreraRepository.delete(carrera);

    }
}
