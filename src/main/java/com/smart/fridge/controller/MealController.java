package com.smart.fridge.controller;


import com.smart.fridge.domain.Meal;
import com.smart.fridge.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
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
    public Meal findMealByName(@QueryParam(value = "mealName") String mealName) {
        return mealService.findMealByName("TestMeal");
    }

    @GET
    @Path("/getMeals")
    @Produces("application/json")
    public Response findAllMeals() {
        Response response;
        List<Meal> mealList = mealService.findAllMeals();
        if (mealList.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(mealList).build();
        }
        return response;
    }
}
