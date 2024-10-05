package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.service.AdminContenidoEducativoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/contenidoEducativos")

public class AdminContenidoEducativoController {

    private final AdminContenidoEducativoService adminContenidoEducativoService;

    // Responder las listas
    @GetMapping
    public ResponseEntity<List<ContenidoEducativoDTO>> getListaContenidoEducativo(){
        List<ContenidoEducativoDTO> contenidoEducativo = adminContenidoEducativoService.getAll();
        return new ResponseEntity<>(contenidoEducativo, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<ContenidoEducativoDTO> getContenidoEducativoById(@PathVariable("id") Long id){
        ContenidoEducativoDTO contenidoEducativo = adminContenidoEducativoService.findById(id);
        return new ResponseEntity<>(contenidoEducativo, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<ContenidoEducativoDTO> create(@Valid @RequestBody ContenidoEducativoDTO contenidoEducativoDTO){

        ContenidoEducativoDTO createContenidoEducativo = adminContenidoEducativoService.create(contenidoEducativoDTO);
        return new ResponseEntity<>(createContenidoEducativo, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<ContenidoEducativoDTO> update(@PathVariable("id") Long id,@Valid@RequestBody ContenidoEducativoDTO contenidoEducativoDTO){

        ContenidoEducativoDTO updateContenidoEducativo = adminContenidoEducativoService.update(id,contenidoEducativoDTO);
        return new ResponseEntity<>(updateContenidoEducativo, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminContenidoEducativoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
