package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.PagoCreateDTO;
import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.dto.PagoReportDTO;
import com.vocaciON.vocacion_service.model.entity.Pago;
import com.vocaciON.vocacion_service.service.AdminPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@PreAuthorize("hastRole('USER')")
@RestController
@RequestMapping("/admin/pagos")

public class AdminPagoController {

    private final AdminPagoService adminPagoService;

    @GetMapping
    public ResponseEntity<List<PagoDTO>> listAllPagos() {
        List<PagoDTO> pagos = adminPagoService.getAllPagos();
        return ResponseEntity.ok(pagos);

    }

    @PostMapping
    public ResponseEntity<PagoDTO> createPago(@RequestBody PagoCreateDTO pagoCreateDTO) {
        PagoDTO savedPago = adminPagoService.createPago(pagoCreateDTO);
        return new ResponseEntity<>(savedPago, HttpStatus.CREATED);
    }

    @GetMapping("/report")
    public ResponseEntity<List<PagoReportDTO>> getPagoReports() {
        List<PagoReportDTO> reports =adminPagoService.getPagoReportByDate();
        return ResponseEntity.ok(reports);
    }


    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PagoDTO>> getPagoHistoryByUsuarioId(@PathVariable Long usuarioId) {
        List<PagoDTO> pagoHistory = adminPagoService.getPagoHistoryByUsuarioId(usuarioId);
        return ResponseEntity.ok(pagoHistory);
    }




}
