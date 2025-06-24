package com.trabajo.posappseguras.models.dao;

import com.trabajo.posappseguras.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
}
