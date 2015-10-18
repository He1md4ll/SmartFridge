package com.smart.fridge.domain;

public class MealPerformance {

    private long id;
    private String name;
    private String url;

    public static MealPerformance fromMeal(Meal meal) {
        MealPerformance mealPerformance = new MealPerformance();
        mealPerformance.setId(meal.getId());
        mealPerformance.setName(meal.getName());
        mealPerformance.setUrl(meal.getUrl());
        return mealPerformance;
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
