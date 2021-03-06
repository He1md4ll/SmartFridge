package com.smart.fridge.domain;

import javax.persistence.*;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "url", nullable = true)
    private String url = "http://panow.com/sites/default/files/styles/homepage_grid/public/default_images/image-placeholder_3.jpg";

    public Meal() {
    }

    public Meal(String name) {
        this.name = name;
    }

    public Meal(String name, String url) {
        this.name = name;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
