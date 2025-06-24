package com.trabajo.posappseguras.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "rol")
    private String rol;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToMany
    @JoinTable(
            name = "rol_competencia",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_competencias")
    )
    private List<Competencia> competencias;

    public boolean sexisterol(String rol) {
        // Lógica de validación implementada en el servicio
        return true;
    }

    public boolean estado(String estado) {
        return this.estado;
    }
}
