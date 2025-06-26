package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Item_Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface IItem_FacturaDao extends JpaRepository<Item_Factura, Integer> {

}
