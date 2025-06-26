package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Clasificacion;

import java.util.List;

public interface IClasificacionService {
    List<Clasificacion> findAll();
    Clasificacion findById(Integer id);
    Clasificacion save(Clasificacion clasificacion);
    void delete(Integer id);
}
