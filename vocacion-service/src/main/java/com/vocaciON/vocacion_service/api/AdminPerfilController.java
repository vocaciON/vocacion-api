package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.PerfilDTO;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.service.AdminPerfilService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/perfiles")

public class AdminPerfilController {

    private final AdminPerfilService adminPerfilService;


    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<PerfilDTO>> getListaPerfil(){
        List<PerfilDTO> perfiles = adminPerfilService.getAll();
        return new ResponseEntity<>(perfiles, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> getPerfilById(@PathVariable("id") Long id){
        PerfilDTO perfil = adminPerfilService.findById(id);
        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<PerfilDTO> create(@Valid @RequestBody PerfilDTO perfilDTO){

        PerfilDTO createPerfil = adminPerfilService.create(perfilDTO);
        return new ResponseEntity<>(createPerfil, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> update(@PathVariable("id") Long id,@Valid@RequestBody PerfilDTO perfilDTO){

        PerfilDTO updatePerfil = adminPerfilService.update(id,perfilDTO);
        return new ResponseEntity<>(updatePerfil, HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminPerfilService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
