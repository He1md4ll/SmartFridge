package com.smart.fridge.controller;

import com.smart.fridge.domain.Day;
import com.smart.fridge.domain.MealPlan;
import com.smart.fridge.domain.MealTime;
import com.smart.fridge.services.MealPlanService;
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
public class MealPlanController {

    @Autowired
    private MealPlanService mealPlanService;

    @GET
    @Produces("application/json")
    @Path("/getMealsOfDay")
    public Response getMealsOfDay(@QueryParam(value = "day") Day day) {
        List<MealPlan> mealPlanList = mealPlanService.getMealsOfDay(day);
        Response response;
        if (mealPlanList.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok().entity(mealPlanList).build();
        }
        return response;
    }

    @GET
    @Produces("application/json")
    @Path("/addMealToMealPlan")
    public Response createMealPlan(@QueryParam("mealID") long mealID, @QueryParam("mealTime") MealTime mealTime, @QueryParam("day") Day day) {
        mealPlanService.createMealPlan(mealID, mealTime, day);
        return Response.ok().build();
    }

    @GET
    @Produces("application/json")
    @Path("/removeMealFromMealPlan")
    public Response removeMealPlan(@QueryParam("mealPlanID") long mealPlanID) {
        Response response;
        boolean success = mealPlanService.removeMealPlan(mealPlanID);
        if (success) {
            response = Response.ok().build();
        } else {
            response = Response.noContent().build();
        }
        return response;
    }
}
