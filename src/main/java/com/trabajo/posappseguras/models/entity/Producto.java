package com.trabajo.posappseguras.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "unidad")
    private String unidad;

    @Column(name = "id_clasificacion")
    private Integer idClasificacion;

    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "iva")
    private Boolean iva;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion", insertable = false, updatable = false)
    @JsonBackReference
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", insertable = false, updatable = false)
    @JsonBackReference
    private Proveedores proveedor;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Item_Factura> itemsFactura;

    public List<Item_Factura> getItemsFactura() {
        return itemsFactura;
    }

    public void setItemsFactura(List<Item_Factura> itemsFactura) {
        this.itemsFactura = itemsFactura;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Boolean getIva() {
        return iva;
    }

    public void setIva(Boolean iva) {
        this.iva = iva;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
