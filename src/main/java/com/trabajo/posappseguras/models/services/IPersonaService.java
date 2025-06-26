package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> findAll();
    Persona findById(Integer id);
    Persona save(Persona persona);
    void delete(Integer id);

    //Persona buscarPorDni(String dni);
    //String nombreCompletoPorDni(String dni);

}
