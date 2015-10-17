package com.smart.fridge.controller;


import com.smart.fridge.domain.Meal;
import com.smart.fridge.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/rest")
@Component
public class MealController {

    @Autowired
    private MealService mealService;

    @GET
    @Path("/createMeal")
    @Produces("application/json")
    public String createMeal() {
        return mealService.createMeal();
    }

    @GET
    @Path("/findMeal")
    @Produces("application/json")
    public Meal findMealByName() {
        return mealService.findMealByName("TestMeal");
    }

    @GET
    @Path("/findAllMeals")
    @Produces("application/json")
    public List<Meal> findAllMeals() {
        return mealService.findAllMeals();
    }
}
