package com.smart.fridge.domain;

import com.smart.fridge.domain.enums.Day;
import com.smart.fridge.domain.enums.MealTime;

import javax.persistence.*;

@Entity
@Table(name = "mealplan")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Meal meal;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "mealTime", nullable = false)
    private MealTime mealTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "day", nullable = false)
    private Day day;

    public MealPlan() {
    }

    public MealPlan(Meal meal, MealTime mealTime, Day day) {
        this.meal = meal;
        this.mealTime = mealTime;
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
