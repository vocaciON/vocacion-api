package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.mapper.AsesoriaMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.enums.EstadoAsesoria;
import com.vocaciON.vocacion_service.repository.AsesoriaRepository;
import com.vocaciON.vocacion_service.repository.ExpertoRepository;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.service.AdminAsesoriaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminAsesoriaServiceImpl implements AdminAsesoriaService {

    private final AsesoriaRepository asesoriaRepository;
    private final ExpertoRepository expertoRepository;
    private final PerfilRepository perfilRepository;

    private final AsesoriaMapper asesoriaMapper;




    @Transactional(readOnly = true)
    @Override
    public List<AsesoriaDTO> getAll() {

        List<Asesoria> asesorias = asesoriaRepository.findAll();

        return asesorias.stream().map(asesoriaMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public AsesoriaDTO findById(Long id) { //buscar
        Asesoria asesoria = asesoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asesoria con el id " + id + " no existe"));
        return asesoriaMapper.toDTO(asesoria);

    }

    @Transactional
    @Override
    public AsesoriaDTO create(AsesoriaDTO asesoriaDTO) { //crear

        Asesoria asesoria = asesoriaMapper.toEntity(asesoriaDTO);
        asesoria.setFechaCreate(LocalDateTime.now());
        asesoria = asesoriaRepository.save(asesoria);


        //**************************************************************
        asesoria.setEstadoAsesoria(EstadoAsesoria.PENDIENTE);
        //*************************************************************


        return asesoriaMapper.toDTO(asesoria);
    }

    @Transactional
    @Override
    public AsesoriaDTO update(Long id, AsesoriaDTO updateAsesoriaDTO) {//actualizar
        Asesoria asesoriaFromDB = asesoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La asesoria con el id " + id + " no existe"));

        /**Experto experto = expertoRepository.findById(updateAsesoria.getExperto().getId())
                        .orElseThrow(() -> new RuntimeException("Experto no encontrado"+ updateAsesoria.getExperto().getId()));
        Perfil perfil = perfilRepository.findById(updateAsesoria.getPerfil().getId())
                        .orElseThrow(() -> new RuntimeException("Perfil no encontrado"+ updateAsesoria.getPerfil().getId()));**/

        asesoriaFromDB.setTemaTratar(updateAsesoriaDTO.getTemaTratar());
        asesoriaFromDB.setFechaAsesoria(updateAsesoriaDTO.getFechaAsesoria());

        asesoriaFromDB.setFechaCreate(LocalDateTime.now());
        asesoriaFromDB.setFechaUpdate(LocalDateTime.now());
        asesoriaFromDB.setLinkAsesoria(updateAsesoriaDTO.getLinkAsesoria());

        /**asesoriaFromDB.setExperto(experto);
        asesoriaFromDB.setPerfil(perfil);**/



        asesoriaFromDB = asesoriaRepository.save(asesoriaFromDB);
        return asesoriaMapper.toDTO(asesoriaFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Asesoria asesoria = asesoriaRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Asesoria con el id " + id + " no existe"));
        asesoriaRepository.delete(asesoria);

    }

}
