package com.smart.fridge.controller;


import com.google.common.base.Preconditions;
import com.smart.fridge.domain.Meal;
import com.smart.fridge.domain.MealAddition;
import com.smart.fridge.domain.MealPerformance;
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

    @Autowired
    private CustomResponseBuilder customResponseBuilder;

    @GET
    @Path("/createMeal")
    @Produces("application/json")
    public String createMeal() {
        return mealService.createMeal();
    }

    @GET
    @Path("/getMealByName")
    @Produces("application/json")
    public Response getMealByName(@QueryParam(value = "mealName") String mealName) {
        Preconditions.checkNotNull(mealName, "MealName can not be null!");

        Response response;
        Meal meal = mealService.getMealByName(mealName);
        if (meal == null) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(meal).build();
        }
        return customResponseBuilder.buildCustomResponse(response);
    }

    @GET
    @Path("/getMealByNameLike")
    @Produces("application/json")
    public Response getMealByNameLikeName(@QueryParam(value = "mealName") String mealName) {
        Preconditions.checkNotNull(mealName, "MealName can not be null!");

        Response response;
        List<Meal> mealList = mealService.getMealByNameLike(mealName);
        if (mealList.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(mealList).build();
        }
        return customResponseBuilder.buildCustomResponse(response);
    }

    @GET
    @Path("/getMeals")
    @Produces("application/json")
    public Response getMeals() {
        Response response;
        List<MealPerformance> mealList = mealService.getMeals();
        if (mealList.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(mealList).build();
        }
        return customResponseBuilder.buildCustomResponse(response);
    }

    @GET
    @Produces("application/json")
    @Path("/getMealAdditionOfMeal")
    public Response getMealAdditionOfMeal(@QueryParam(value = "mealID") int mealID) {
        Preconditions.checkNotNull(mealID, "MealID can not be null!");

        List<MealAddition> mealAdditionList = mealService.getMealAdditionsOfMeal(mealID);
        Response response;
        if (mealAdditionList.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(mealAdditionList).build();
        }
        return customResponseBuilder.buildCustomResponse(response);
    }
}
