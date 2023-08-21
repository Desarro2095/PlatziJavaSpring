package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categorias")
public class Category {

    @Id
    @Column(name="id_categoria")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer CategoryId;

    @Column(name="descripcion")
    private String Description;

    @Column(name="State")
    private Boolean State;

    @OneToMany(mappedBy="Category")
    private List<Product> Products;

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getState() {
        return State;
    }

    public void setState(Boolean state) {
        State = state;
    }
}
