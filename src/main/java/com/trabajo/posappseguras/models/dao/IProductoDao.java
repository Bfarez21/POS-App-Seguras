package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto, Long> {
}
