package com.trabajo.posappseguras.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "id_tipo_pago")
    private Integer idTipoPago;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", insertable = false, updatable = false)
    private Tipo_Pago tipoPago;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Item_Factura> items;
}