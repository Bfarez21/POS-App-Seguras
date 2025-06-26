package com.trabajo.posappseguras.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    // Relación con Persona (One-to-One)
    @OneToOne
    @JoinColumn(name = "id_persona")
    @JsonManagedReference
    private Persona persona;

    // Relación con Rol (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "id_rol")
    @JsonBackReference
    private Rol rol;

    // ELIMINAMOS la relación directa con Factura
    // Las facturas se acceden a través de persona.getFacturas()

    // Constructors
    public Usuario() {}

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean siexiste(String user, String password) {
        // Lógica de validación implementada en el servicio
        return true;
    }
}