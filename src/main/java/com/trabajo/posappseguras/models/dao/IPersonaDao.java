package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
}
