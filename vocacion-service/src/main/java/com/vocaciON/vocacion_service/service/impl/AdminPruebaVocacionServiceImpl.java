package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.dto.ExpertoDTO;
import com.vocaciON.vocacion_service.dto.PruebaVocacionDTO;
import com.vocaciON.vocacion_service.mapper.PruebaVocacionMapper;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.repository.PruebaVocacionRepository;
import com.vocaciON.vocacion_service.service.AdminPruebaVocacionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data


public class AdminPruebaVocacionServiceImpl implements AdminPruebaVocacionService {

    private final PruebaVocacionRepository pruebaVocacionRepository;

    private final PerfilRepository perfilRepository;

    private final PruebaVocacionMapper pruebaVocacionMapper;

    @Transactional(readOnly = true)
    @Override
    public List<PruebaVocacionDTO> getAll() {

        List<PruebaVocacion> pruebaVocacions = pruebaVocacionRepository.findAll();

        return pruebaVocacions.stream().map(pruebaVocacionMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public PruebaVocacionDTO create(PruebaVocacionDTO pruebaVocacionDTO) { //crear

        PruebaVocacion pruebaVocacion = pruebaVocacionMapper.toEntity(pruebaVocacionDTO);
        pruebaVocacion.setFechaCreate(LocalDateTime.now());
        pruebaVocacion = pruebaVocacionRepository.save(pruebaVocacion);

        return pruebaVocacionMapper.toDTO(pruebaVocacion);
    }

    @Transactional(readOnly = true)
    @Override
    public PruebaVocacionDTO findById(Long id) { //buscar
        PruebaVocacion pruebaVocacion = pruebaVocacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prueba con el id " + id + " no existe"));
        return pruebaVocacionMapper.toDTO(pruebaVocacion);

    }
    @Transactional
    @Override
    public PruebaVocacionDTO update(Long id, PruebaVocacionDTO updatePruebaVocacionDTO) {//actualizar
        PruebaVocacion pruebaVocacionFromDB = pruebaVocacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La prueba con el id " + id + " no existe"));


        /*Perfil perfil = perfilRepository.findById(UpdatePruebaVocacion.getPerfil().getId())
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ UpdatePruebaVocacion.getPerfil().getId()));*/

        pruebaVocacionFromDB.setNombre(updatePruebaVocacionDTO.getNombre());
        pruebaVocacionFromDB.setDescripcion(updatePruebaVocacionDTO.getDescripcion());




        pruebaVocacionFromDB = pruebaVocacionRepository.save(pruebaVocacionFromDB);
        return pruebaVocacionMapper.toDTO(pruebaVocacionFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        PruebaVocacion pruebaVocacion = pruebaVocacionRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Prueba con el id " + id + " no existe"));
        pruebaVocacionRepository.delete(pruebaVocacion);

    }
}
