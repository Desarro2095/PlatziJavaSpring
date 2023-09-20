package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categorias")
public class EntityCategory {

    @Id
    @Column(name="id_categoria")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name="descripcion")
    private String description;

    @Column(name="estado")
    private Boolean state;

    @OneToMany(mappedBy="category")
    private List<EntityProduct> products;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public List<EntityProduct> getProducts() { return products; }

    public void setProducts(List<EntityProduct> products) { this.products = products; }
}
