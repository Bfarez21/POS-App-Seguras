package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolDao extends JpaRepository<Rol, Long> {
}
