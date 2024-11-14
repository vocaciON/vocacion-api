package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.ExpertoCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ExpertoDTO;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Experto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component

public class ExpertoMapper {
    
    private final ModelMapper modelMapper;
    
    public ExpertoMapper(ModelMapper modelMapper) {


        this.modelMapper = modelMapper;
        //Configurar el model Mapper para usar estrategia de coincidencia estricta
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ExpertoDTO toDTO(Experto experto) {


        ExpertoDTO expertoDTO = modelMapper.map(experto, ExpertoDTO.class);


        return modelMapper.map(experto, ExpertoDTO.class);
    }

    public Experto toEntity(ExpertoCreateUpdateDTO expertoCreateUpdateDTO) {
        return modelMapper.map(expertoCreateUpdateDTO, Experto.class);

    }

    public ExpertoCreateUpdateDTO toCreateUpdateDTO(Experto experto) {
        return modelMapper.map(experto, ExpertoCreateUpdateDTO.class);
    }

}

    
 