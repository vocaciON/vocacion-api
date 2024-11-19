package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.dto.AsesoriaCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.AsesoriaCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.AsesoriaMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.model.entity.Usuario;
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
                .orElseThrow(() -> new ResourceNotFoundException("Asesoria con el id " + id + " no existe"));
        return asesoriaMapper.toDTO(asesoria);

    }

    @Transactional
    @Override
    public AsesoriaDTO create(AsesoriaCreateUpdateDTO asesoriaCreateUpdateDTO) {
        // Verifica que el Usuario asociado existe

        Perfil perfil = perfilRepository.findById(asesoriaCreateUpdateDTO.getPerfilId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con id " + asesoriaCreateUpdateDTO.getPerfilId() + " no encontrado"));

        Experto experto = expertoRepository.findById(asesoriaCreateUpdateDTO.getExpertoId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con id " + asesoriaCreateUpdateDTO.getExpertoId() + " no encontrado"));

        Asesoria asesoria = asesoriaMapper.toEntity(asesoriaCreateUpdateDTO);

        asesoria.setPerfil(perfil); // Asigna el perfil a la asesoria
        asesoria.setExperto(experto); // Asigna el experto a la asesoria
        asesoria.setFechaCreate(LocalDateTime.now());



        return asesoriaMapper.toDTO(asesoriaRepository.save(asesoria));
    }

    @Transactional
    @Override
    public AsesoriaDTO update(Long id, AsesoriaCreateUpdateDTO updateAsesoriaDTO) {
        // Buscar asesoria en la base de datos por su ID
        Asesoria asesoriaFromDB = asesoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La asesoria con el id " + id + " no existe"));

        //Asignar el perfil antes de actualizar
        Perfil perfil = perfilRepository.findById(updateAsesoriaDTO.getPerfilId())
                .orElseThrow(() -> new ResourceNotFoundException("Perfil con id " + updateAsesoriaDTO.getPerfilId() + " no encontrado"));
        asesoriaFromDB.setPerfil(perfil);

        //Asignar el Experto antes de actualizar
        Experto experto = expertoRepository.findById(updateAsesoriaDTO.getExpertoId())
                .orElseThrow(() -> new ResourceNotFoundException("Experto con id " + updateAsesoriaDTO.getExpertoId() + " no encontrado"));
        asesoriaFromDB.setExperto(experto);

        // Actualizar los campos de Asesoria con los valores del DTO
        asesoriaFromDB.setTemaTratar(updateAsesoriaDTO.getTemaTratar());
        asesoriaFromDB.setFechaAsesoria(updateAsesoriaDTO.getFechaAsesoria());
        asesoriaFromDB.setLinkAsesoria(updateAsesoriaDTO.getLinkAsesoria());
        asesoriaFromDB.setEstadoAsesoria(updateAsesoriaDTO.getEstadoAsesoria());
        asesoriaFromDB.setPerfil(perfil);
        asesoriaFromDB.setExperto(experto);
        asesoriaFromDB.setFechaUpdate(LocalDateTime.now()); // Actualizar la fecha de actualización


        // Guardar el perfil actualizado
        asesoriaRepository.save(asesoriaFromDB);

        // Convertir la entidad actualizada a DTO y devolverla
        return asesoriaMapper.toDTO(asesoriaFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Asesoria asesoria = asesoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El experto con id " + id + " no existe"));

    }

}
