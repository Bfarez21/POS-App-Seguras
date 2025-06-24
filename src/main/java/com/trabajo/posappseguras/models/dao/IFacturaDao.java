package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaDao extends JpaRepository<Factura, Long> {
}
