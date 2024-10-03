package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.UsuarioDTO;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {
    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
}
