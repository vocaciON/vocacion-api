package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.service.AdminAsesoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/asesorias")

public class AdminAsesoriaController {

    private final AdminAsesoriaService adminAsesoriaService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<Asesoria>> getListaAsesoria(){
        List<Asesoria> asesorias = adminAsesoriaService.getAll();
        return new ResponseEntity<List<Asesoria>>(asesorias, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<Asesoria> getAsesoriaById(@PathVariable("id") Long id){
        Asesoria asesoria = adminAsesoriaService.findById(id);
        return new ResponseEntity<Asesoria>(asesoria, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<Asesoria> createAsesoria(@RequestBody Asesoria asesoria){

        Asesoria newAsesoria = adminAsesoriaService.create(asesoria);
        return new ResponseEntity<Asesoria>(newAsesoria, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<Asesoria> updateAsesoria(@PathVariable("id") Long id,
                                                 @RequestBody Asesoria asesoria){

        Asesoria updateAsesoria = adminAsesoriaService.update(id,asesoria);
        return new ResponseEntity<Asesoria>(updateAsesoria, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Asesoria> deleteAsesoria(@PathVariable("id") Long id,
                                                 @RequestBody Asesoria asesoria){

        adminAsesoriaService.delete(id);
        return new ResponseEntity<Asesoria>(HttpStatus.NO_CONTENT);

    }


}
