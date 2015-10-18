package com.smart.fridge.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<MealAddition> mealAdditions;

    @Column(name = "url", nullable = true)
    private String url = "http://panow.com/sites/default/files/styles/homepage_grid/public/default_images/image-placeholder_3.jpg";

    public Meal() {
    }

    public Meal(String name, List<MealAddition> mealAdditions) {
        this.name = name;
        this.mealAdditions = mealAdditions;
    }

    public Meal(String name, List<MealAddition> mealAdditions, String url) {
        this.name = name;
        this.mealAdditions = mealAdditions;
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

    public List<MealAddition> getMealAdditions() {
        return mealAdditions;
    }

    public void setMealAdditions(List<MealAddition> mealAdditions) {
        this.mealAdditions = mealAdditions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
