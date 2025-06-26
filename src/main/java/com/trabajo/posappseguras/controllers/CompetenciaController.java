package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Competencia;
import com.trabajo.posappseguras.models.services.ICompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CompetenciaController {

    @Autowired
    private ICompetenciaService competenciaService;

    @GetMapping("/competencia")
    public List<Competencia> index() {
        return competenciaService.findAll();
    }

    @GetMapping("/competencia/{id}")
    public Competencia show(@PathVariable Integer id) {
        return competenciaService.findById(id);
    }

    @PostMapping("/competencia")
    @ResponseStatus(HttpStatus.CREATED)
    public Competencia create(@RequestBody Competencia competencia) {
        return competenciaService.save(competencia);
    }

    @PutMapping("/competencia/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Competencia update(@RequestBody Competencia competencia, @PathVariable Integer id) {
        Competencia competenciaActual = competenciaService.findById(id);

        if (competenciaActual != null) {
            competenciaActual.setNombre(competencia.getNombre());
            competenciaActual.setDescripcion(competencia.getDescripcion());
            return competenciaService.save(competenciaActual);
        }
        return null; // Mejor manejar error 404 en producción
    }

    @DeleteMapping("/competencia/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        competenciaService.delete(id);
    }
}
