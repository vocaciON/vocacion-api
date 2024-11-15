package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.PerfilDTO;
import com.vocaciON.vocacion_service.mapper.PerfilMapper;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.repository.ContenidoEducativoRepository;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.repository.UsuarioRepository;
import com.vocaciON.vocacion_service.service.AdminPerfilService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;



@Service
@RequiredArgsConstructor
@Data

public class AdminPerfilServiceImpl implements AdminPerfilService {

    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;

    private final PerfilMapper perfilMapper;


    @Transactional(readOnly = true)
    @Override
    public List<PerfilDTO> getAll() {

        List<Perfil> perfiles = perfilRepository.findAll();

        return perfiles.stream().map(perfilMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public PerfilDTO findById(Long id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El perfil con id " + id + " no existe"));
        return perfilMapper.toDTO(perfil);
        }



    @Transactional
    @Override
    public PerfilDTO create(PerfilDTO perfilDTO) { //crear

        Perfil perfil = perfilMapper.toEntity(perfilDTO);
        perfil.setFechaCreate(LocalDateTime.now());
        perfil = perfilRepository.save(perfil);



        /*perfil.setUsuario(usuario);*/


        return perfilMapper.toDTO(perfil);
    }

    @Transactional
    @Override
    public PerfilDTO update(Long id, PerfilDTO updatePerfilDTO) {//actualizar
        Perfil perfilFromDB = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El estudiante con el id " + id + " no existe"));

        perfilFromDB.setDescripcion(updatePerfilDTO.getDescripcion());
        perfilFromDB.setGradoAcademico(updatePerfilDTO.getGradoAcademico());

        perfilFromDB.setInstitucionEstudio(updatePerfilDTO.getInstitucionEstudio());
        perfilFromDB.setCarrerasInteres(updatePerfilDTO.getCarrerasInteres());

        /*perfilFromDB.setUsuario(usuario);*/



        perfilFromDB = perfilRepository.save(perfilFromDB);
        return perfilMapper.toDTO(perfilFromDB);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Perfil perfil = perfilRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Asesoria con el id " + id + " no existe"));
        perfilRepository.delete(perfil);

    }
}
