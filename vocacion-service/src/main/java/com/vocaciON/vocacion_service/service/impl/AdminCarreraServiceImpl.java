package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.dto.CarreraDTO;
import com.vocaciON.vocacion_service.mapper.CarreraMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Carrera;
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

    @Transactional(readOnly = true)
    @Override

    public List<CarreraDTO> getAll() {
        List<Carrera> carreras = carreraRepository.findAll();

        return carreras.stream().map(carreraMapper::toDTO).toList();


    }
    @Transactional(readOnly = true)
    @Override
    public Carrera findById(Long id) { //buscar
        return carreraRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Carrera  no encontrado"));

    }

    @Transactional
    @Override
    public Carrera create(Carrera carrera) { //crear
        carrera.setCreatedAt(LocalDateTime.now());// setear la fecha de creacion
        return carreraRepository.save(carrera);
    }

    @Transactional
    @Override
    public Carrera update(Long id, Carrera updateCarrera) {//actualizar
        Carrera carreraFromDB = findById(id);

        carreraFromDB.setNombre(updateCarrera.getNombre());
        carreraFromDB.setDescripcion(updateCarrera.getDescripcion());




        return carreraRepository.save(carreraFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Carrera carrera = findById(id);
        carreraRepository.delete(carrera);

    }
}
