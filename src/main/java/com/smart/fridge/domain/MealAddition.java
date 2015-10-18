package com.smart.fridge.domain;

import javax.persistence.*;

@Entity
@Table(name = "mealaddition")
public class MealAddition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long meal_addition_id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Ingredient ingredient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Meal meal;

    public MealAddition() {
    }

    public MealAddition(int amount, Ingredient ingredient, Meal meal) {
        this.amount = amount;
        this.ingredient = ingredient;
        this.meal = meal;
    }

    public long getMeal_addition_id() {
        return meal_addition_id;
    }

    public void setMeal_addition_id(long meal_addition_id) {
        this.meal_addition_id = meal_addition_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
