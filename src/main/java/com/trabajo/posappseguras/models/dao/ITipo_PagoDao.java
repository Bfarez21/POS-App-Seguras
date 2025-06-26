package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Tipo_Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface ITipo_PagoDao extends JpaRepository<Tipo_Pago, Integer> {

}
