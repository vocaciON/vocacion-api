package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.CompraPlanCreateDTO;
import com.vocaciON.vocacion_service.dto.CompraPlanDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.CompraPlanMapper;
import com.vocaciON.vocacion_service.model.entity.CompraPlan;
import com.vocaciON.vocacion_service.repository.CompraPlanRepository;
import com.vocaciON.vocacion_service.service.AdminCompraPlanService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminCompraPlanServiceImpl implements AdminCompraPlanService {

    private final CompraPlanRepository compraPlanRepository;

    private final CompraPlanMapper compraPlanMapper;

  //obtener la lista de todos los planes
    @Transactional(readOnly = true)
    @Override
    public List<CompraPlanDTO> getAll() {

        List<CompraPlan> compraPlans = compraPlanRepository.findAll();

        return compraPlans.stream().map(compraPlanMapper::toDTO).toList();
    }
    @Transactional(readOnly = true)
    @Override
    public CompraPlanDTO findById(Long id) { //buscar
        CompraPlan compraPlan = compraPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plan con el id " + id + " no existe"));
        return compraPlanMapper.toDTO(compraPlan);

    }

    @Transactional
    @Override
    public CompraPlanDTO create(CompraPlanCreateDTO compraPlanCreateDTO) {
        // Verifica que el Usuario asociado existe


        CompraPlan compraPlan = compraPlanMapper.toEntity(compraPlanCreateDTO);
        compraPlan.setCreatedAT(LocalDateTime.now());



        return compraPlanMapper.toDTO(compraPlanRepository.save(compraPlan));
    }

    @Transactional
    @Override
    public CompraPlanDTO update(Long id, CompraPlanCreateDTO updateExpertolDTO) {
        // Buscar el perfil en la base de datos por su ID
        CompraPlan compraPlanFromDB = compraPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Plan con el id " + id + " no existe"));

        //Asignar el usuario antes de actualizar


        // Actualizar los campos de perfil con los valores del DTO
        compraPlanFromDB.setNombrePlan(updateExpertolDTO.getNombrePlan());
        compraPlanFromDB.setDescripcionPlan(updateExpertolDTO.getDescripcionPlan());
        compraPlanFromDB.setTotal(updateExpertolDTO.getTotal());


        compraPlanFromDB.setCreatedAT(LocalDateTime.now()); // Actualizar la fecha de actualización


        // Guardar el perfil actualizado
        compraPlanRepository.save(compraPlanFromDB);

        // Convertir la entidad actualizada a DTO y devolverla
        return compraPlanMapper.toDTO(compraPlanFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        CompraPlan experto = compraPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El plan con id " + id + " no existe"));


    }
}
