package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.ContenidoEducativoDetailsDTO;
import com.vocaciON.vocacion_service.service.AdminContenidoEducativoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contenidoEducativo")
@RequiredArgsConstructor
public class HomeContenidoEducativoController {
    private final AdminContenidoEducativoService adminContenidoEducativoService;

    @GetMapping("/media")
    public ResponseEntity<List<ContenidoEducativoDetailsDTO>> getRecentContenidoEducativo() {
        List<ContenidoEducativoDetailsDTO> recentContenidoEducativo = adminContenidoEducativoService.findTop6ContenidoEducativoByCreatedAt();
        return new ResponseEntity<>(recentContenidoEducativo, HttpStatus.OK);
    }
}
