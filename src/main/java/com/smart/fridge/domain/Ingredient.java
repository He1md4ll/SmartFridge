package com.smart.fridge.domain;

import com.smart.fridge.domain.enums.Unit;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "unit", nullable = false)
    private Unit unit;

    @Column(name = "url", nullable = true)
    private String url = "http://panow.com/sites/default/files/styles/homepage_grid/public/default_images/image-placeholder_3.jpg";

    public Ingredient() {
    }

    public Ingredient(String name, Unit unit) {
        this.name = name;
        this.unit = unit;
    }

    public Ingredient(String name, Unit unit, String url) {
        this.name = name;
        this.unit = unit;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
