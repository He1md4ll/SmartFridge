package com.smart.fridge.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<MealAddition> mealAdditions;

    public Meal() {
    }

    public Meal(String name, List<MealAddition> mealAdditions) {
        this.name = name;
        this.mealAdditions = mealAdditions;
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
}
