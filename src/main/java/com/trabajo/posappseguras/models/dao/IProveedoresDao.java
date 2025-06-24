package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedoresDao extends JpaRepository<Proveedores, Long> {
}
