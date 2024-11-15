package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.CompraPlanCreateDTO;
import com.vocaciON.vocacion_service.dto.CompraPlanDTO;
import com.vocaciON.vocacion_service.dto.PagoCreateDTO;
import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.model.entity.CompraPlan;
import com.vocaciON.vocacion_service.model.entity.Pago;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component

public class PagoMapper {
    private final ModelMapper modelMapper;

    public PagoMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public Pago toPagoCreateDTO(PagoCreateDTO pagoDTO) {
        Pago pago = modelMapper.map(pagoDTO, Pago.class);

        Usuario usuario = new Usuario();
        usuario.setId(pagoDTO.getUsuarioId());
        pago.setUsuario(usuario);

        return pago;
    }

    public PagoDTO toPagoDTO(Pago pago) {
        PagoDTO pagoDTO = modelMapper.map(pago, PagoDTO.class);
        pagoDTO.setUsuarioName(pago.getUsuario().getNombre()+""+pago.getUsuario().getApellido());
        pagoDTO.setPlanDetalles(pago.getCompraPlan().getNombrePlan()+"/"
                +pago.getCompraPlan().getDescripcionPlan()+
                "/"+pago.getCompraPlan().getTotal());
        return pagoDTO;
    }

    private CompraPlan toCompraPlanEntity(CompraPlanCreateDTO PlanDTO) {
        CompraPlan plan = modelMapper.map(PlanDTO, CompraPlan.class);
        return plan;
    }

    private CompraPlanDTO toCompraPlanDTO(CompraPlan plan) {
        CompraPlanDTO planDTO = modelMapper.map(plan, CompraPlanDTO.class);
        return planDTO;
    }


}
