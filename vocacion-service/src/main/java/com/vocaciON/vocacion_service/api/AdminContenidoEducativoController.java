package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import com.vocaciON.vocacion_service.service.AdminContenidoEducativoService;
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
    public ResponseEntity<List<ContenidoEducativo>> getListaContenidoEducativo() {
        List<ContenidoEducativo> contenidoEducativos = adminContenidoEducativoService.getAll();
        return new ResponseEntity<List<ContenidoEducativo>>(contenidoEducativos, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<ContenidoEducativo> getContenidoEducativoById(@PathVariable("id") Long id){
        ContenidoEducativo contenidoEducativo = adminContenidoEducativoService.findById(id);
        return new ResponseEntity<ContenidoEducativo>(contenidoEducativo, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<ContenidoEducativo> createContenidoEducativo(@RequestBody ContenidoEducativo contenidoEducativo){

        ContenidoEducativo newContenidoEducativo = adminContenidoEducativoService.create(contenidoEducativo);
        return new ResponseEntity<ContenidoEducativo>(newContenidoEducativo, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<ContenidoEducativo> updateContenidoEducativo(@PathVariable("id") Long id,
                                                 @RequestBody ContenidoEducativo contenidoEducativo){

        ContenidoEducativo updateContenidoEducativo = adminContenidoEducativoService.update(id,contenidoEducativo);
        return new ResponseEntity<ContenidoEducativo>(updateContenidoEducativo, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContenidoEducativo> deleteContenidoEducativo(@PathVariable("id") Long id,
                                                 @RequestBody ContenidoEducativo contenidoEducativo){

        adminContenidoEducativoService.delete(id);
        return new ResponseEntity<ContenidoEducativo>(HttpStatus.NO_CONTENT);

    }


}
