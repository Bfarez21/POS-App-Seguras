package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface IProductoDao extends JpaRepository<Producto, Integer> {

}
