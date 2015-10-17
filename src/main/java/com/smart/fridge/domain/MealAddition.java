package com.smart.fridge.domain;

import javax.persistence.*;

@Entity
@Table(name = "mealaddition")
public class MealAddition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "amount")
    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Ingredient ingredient;

    public MealAddition() {
    }

    public MealAddition(int amount, Ingredient ingredient) {
        this.amount = amount;
        this.ingredient = ingredient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
