package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Persona;
import com.trabajo.posappseguras.models.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/persona")
    public List<Persona> index(){return personaService.findAll(); }

    @GetMapping("/persona/{id}")
    public Persona show(@PathVariable Integer id){return personaService.findById(id); }

    @PostMapping("/persona")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona create(@RequestBody Persona persona) {return personaService.save(persona); }

    @PutMapping("/persona/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona persona, @PathVariable Integer id){
        Persona personaActual = personaService.findById(id);

        if (personaActual != null) {
            personaActual.setNombre(persona.getNombre());
            personaActual.setApellido(persona.getApellido());
            personaActual.setDni(persona.getDni());
            personaActual.setCelular(persona.getCelular());
            personaActual.setCorreo(persona.getCorreo());
            // Omitimos usuario y facturas por separado, ya que se gestionan aparte generalmente
            return personaService.save(personaActual);
        }
        return null;
    }

    @DeleteMapping("/persona/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  delete(@PathVariable Integer id){personaService.delete(id);}


    // otros metyodo

    /*@GetMapping("/persona/buscar/{dni}")
    public Persona buscarPorDni(@PathVariable String dni) {
        return personaService.buscarPorDni(dni);
    }

    @GetMapping("/persona/nombre-completo/{dni}")
    public String nombreCompletoPorDni(@PathVariable String dni) {
        return personaService.nombreCompletoPorDni(dni);
    }*/

}
