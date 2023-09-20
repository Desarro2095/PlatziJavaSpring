package com.platzi.market.persistence.entity;
import jakarta.persistence.*;

@Entity
@Table(name="productos", schema = "public")
public class EntityProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer productId;

    @Column(name = "nombre")
    private String name;

    @Column(name="id_categoria")
    private Integer categoryId;

    @Column(name="codigo_barras")
    private String codeBar;

    @Column(name="precio_venta")
    private Double salePrice;

    @Column(name="cantidad_stock")
    private Integer quantityStock;

    @Column(name="estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false, updatable = false)
    private EntityCategory category;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Boolean getState() { return state; }

    public void setState(Boolean state) { this.state = state; }

    public EntityCategory getCategory() { return category; }

    public void setCategory(EntityCategory category) { this.category = category; }
}
