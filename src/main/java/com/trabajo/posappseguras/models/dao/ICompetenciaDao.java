package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompetenciaDao extends JpaRepository<Competencia, Long> {
}
