package com.vocaciON.vocacion_service.service.impl;


import com.vocaciON.vocacion_service.dto.PagoCreateDTO;
import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.dto.PagoReportDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.PagoMapper;
import com.vocaciON.vocacion_service.model.entity.CompraPlan;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Pago;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.model.enums.EstadoPago;
import com.vocaciON.vocacion_service.repository.CompraPlanRepository;
import com.vocaciON.vocacion_service.repository.PagoRepository;
import com.vocaciON.vocacion_service.repository.UsuarioRepository;
import com.vocaciON.vocacion_service.service.AdminPagoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
public class AdminPagoServiceImpl implements AdminPagoService {
    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;


    private final UsuarioRepository usuarioRepository;
    private final CompraPlanRepository compraPlanRepository;

    @Override
    @Transactional
    public PagoDTO createPago(PagoCreateDTO pagoCreateDTO) { //registro de una compra

        Pago pago = pagoMapper.toPagoCreateDTO(pagoCreateDTO);

        //Buscar al usuario
        Usuario usuario = usuarioRepository.findById(pagoCreateDTO.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        //Buscar el plan
        CompraPlan compraPlan = compraPlanRepository.findById(pagoCreateDTO.getCompraPlanId())
                .orElseThrow(() -> new ResourceNotFoundException("Compra Plan no encontrado"));


        //Establecer una fecha de creacion
        pago.setFechaCreate(LocalDateTime.now());

        //Asignar un estado de pago
        pago.setEstadoPago(EstadoPago.PENDING);

        //Calcular el pago
        Float monto=pago.getMonto();
        pago.setMonto(monto);

        // modif usuario
        pago.setUsuario(usuario);

        //modifi el plan
        pago.setCompraPlan(compraPlan);



        //ahora guardare en la DB
        Pago savedPago = pagoRepository.save(pago);
        return pagoMapper.toPagoDTO(savedPago);
    }

    @Override
    public List<PagoDTO> getPagoHistoryByUsuarioId(long usuarioId) { // listado
        return pagoRepository.findByUsuarioId(usuarioId).stream()
                .map(pagoMapper::toPagoDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<PagoReportDTO> getPagoReportByDate() {
        pagoRepository.getPagoReportByDate();
        List<Object[]> results = pagoRepository.getPagoReportByDate();
        //Apicar un mapeo , convertir
        List<PagoReportDTO> pagoReportDTOS = results.stream()
                .map(result ->
                        new PagoReportDTO(
                                ((Integer) result[0]).intValue(),
                                (String)result[1]
                        )
                ).toList();
        return pagoReportDTOS;

    }

    @Override
    public PagoDTO confirmPago(Long pagoId) {
        Pago pago = pagoRepository.findById(pagoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));

        pago.setEstadoPago(EstadoPago.PAID);

        Pago updatedPago = pagoRepository.save(pago);
        return pagoMapper.toPagoDTO(updatedPago);
    }

    @Override
    public PagoDTO getPagoById(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        return pagoMapper.toPagoDTO(pago);
    }

    @Override
    public List<PagoDTO> getAllPagos() {
        List<Pago> pagos = pagoRepository.findAll();

        return pagos.stream().map(pagoMapper::toPagoDTO).toList();
    }
//obtener el pago por id
    @Override
    public PagoDTO findById(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"+id+"no existe"));

        return pagoMapper.toPagoDTO(pago);
    }

    @Override
    public void delete(Long id) {

    }


}
