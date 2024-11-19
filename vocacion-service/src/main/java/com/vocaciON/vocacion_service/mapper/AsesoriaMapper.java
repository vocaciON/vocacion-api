package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.AsesoriaCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component

public class AsesoriaMapper {

    private final ModelMapper modelMapper;

    public AsesoriaMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
        //Configurar el model Mapper para usar estrategia de coincidencia estricta
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public AsesoriaDTO toDTO(Asesoria asesoria) {

        AsesoriaDTO asesoriaDTO = modelMapper.map(asesoria, AsesoriaDTO.class);

        asesoriaDTO.setPerfilName(asesoria.getPerfil().getUsuario().getNombre()+""+asesoria.getPerfil().getUsuario().getApellido());
        asesoriaDTO.setExpertoName(asesoria.getExperto().getUsuario().getNombre()+""+asesoria.getExperto().getUsuario().getApellido());


        return modelMapper.map(asesoria, AsesoriaDTO.class);
    }

    public Asesoria toEntity(AsesoriaCreateUpdateDTO asesoriaCreateUpdateDTO) {
        return modelMapper.map(asesoriaCreateUpdateDTO, Asesoria.class);
    }

    public AsesoriaCreateUpdateDTO toCreateUpdateDTO(Asesoria asesoria) {
        return modelMapper.map(asesoria, AsesoriaCreateUpdateDTO.class);
    }

}
