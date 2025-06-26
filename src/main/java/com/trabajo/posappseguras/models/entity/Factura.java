package com.trabajo.posappseguras.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", insertable = false, updatable = false)
    @JsonBackReference
    private Tipo_Pago tipoPago;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Item_Factura> items;

    public Factura(String ruc, Date fecha, Double descuento, Double total) {
        this.ruc = ruc;
        this.fecha = fecha;
        this.descuento = descuento;
        this.total = total;
    }

    public Tipo_Pago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Tipo_Pago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public List<Item_Factura> getItems() {
        return items;
    }

    public void setItems(List<Item_Factura> items) {
        this.items = items;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}