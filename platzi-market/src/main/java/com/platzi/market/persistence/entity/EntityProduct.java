package com.platzi.market.persistence.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer ProductId;

    @Column(name = "nombre")
    private String Name;

    @Column(name="id_categoria")
    private Integer CategotyId;

    @Column(name="codigo_barras")
    private String CodeBar;

    @Column(name="precio_venta")
    private Double SalePrice;

    @Column(name="cantidad_stock")
    private Integer QuantityStock;

    @Column(name="estado")
    private Boolean State;

    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false, updatable = false)
    private Category Category;

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCategotyId() {
        return CategotyId;
    }

    public void setCategotyId(Integer categotyId) {
        CategotyId = categotyId;
    }

    public String getCodeBar() {
        return CodeBar;
    }

    public void setCodeBar(String codeBar) {
        CodeBar = codeBar;
    }

    public Double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(Double salePrice) {
        SalePrice = salePrice;
    }

    public Integer getQuantityStock() {
        return QuantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        QuantityStock = quantityStock;
    }

    public Boolean getState() {
        return State;
    }

    public void setState(Boolean state) {
        State = state;
    }
}
