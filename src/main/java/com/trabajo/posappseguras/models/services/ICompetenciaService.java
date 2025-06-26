package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Competencia;

import java.util.List;

public interface ICompetenciaService {
    List<Competencia> findAll();
    Competencia findById(Integer id);
    Competencia save(Competencia competencia);
    void delete(Integer id);
}
