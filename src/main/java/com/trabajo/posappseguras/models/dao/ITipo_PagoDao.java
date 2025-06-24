package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Tipo_Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipo_PagoDao extends JpaRepository<Tipo_Pago, Long> {
}
