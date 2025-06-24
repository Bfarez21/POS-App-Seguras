package com.trabajo.posappseguras.models.entity;

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
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", insertable = false, updatable = false)
    private Proveedores proveedor;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Item_Factura> itemsFactura;
}
