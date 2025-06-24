package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClasificacionDao extends JpaRepository<Clasificacion, Long> {
}
