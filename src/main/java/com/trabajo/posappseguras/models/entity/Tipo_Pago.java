package com.trabajo.posappseguras.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tipo_pago")
@Data
@AllArgsConstructor
public class Tipo_Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pago")
    private Integer idTipoPago;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descrip")
    private String descrip;

    // Relación con Factura
    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Factura> facturas;

    // Constructors
    public Tipo_Pago() {
    }

    public Tipo_Pago( String descrip, String tipo) {
        this.descrip = descrip;
        this.tipo = tipo;
    }

    // Getters and Setters
    public Integer getIdTipoPago() { return idTipoPago; }
    public void setIdTipoPago(Integer idTipoPago) { this.idTipoPago = idTipoPago; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescrip() { return descrip; }
    public void setDescrip(String descrip) { this.descrip = descrip; }

    public List<Factura> getFacturas() { return facturas; }
    public void setFacturas(List<Factura> facturas) { this.facturas = facturas; }
}