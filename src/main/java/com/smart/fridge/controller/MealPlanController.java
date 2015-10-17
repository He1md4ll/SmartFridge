package com.smart.fridge.controller;

import com.google.common.base.Preconditions;
import com.smart.fridge.domain.MealPlan;
import com.smart.fridge.domain.enums.Day;
import com.smart.fridge.domain.enums.MealTime;
import com.smart.fridge.services.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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
        Preconditions.checkNotNull(day, "Day can not be null!");

        Response response;
        List<MealPlan> mealPlanList = mealPlanService.getMealsOfDay(day);
        if (mealPlanList.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok().entity(mealPlanList).build();
        }
        return response;
    }

    @PUT
    @Produces("application/json")
    @Path("/addMealToMealPlan")
    public Response createMealPlan(@QueryParam("mealID") long mealID, @QueryParam("mealTime") MealTime mealTime, @QueryParam("day") Day day) {
        Preconditions.checkNotNull(mealID, "MealID can not be null!");
        Preconditions.checkNotNull(mealTime, "MealTime can not be null!");
        Preconditions.checkNotNull(day, "Day can not be null!");

        Response response;
        MealPlan mealPlan = mealPlanService.createMealPlan(mealID, mealTime, day);
        if (mealPlan == null) {
            response = Response.status(Response.Status.PRECONDITION_FAILED).build();
        } else {
            response = Response.ok(mealPlan).build();
        }
        return response;
    }

    @DELETE
    @Produces("application/json")
    @Path("/removeMealFromMealPlan")
    public Response removeMealPlan(@QueryParam("mealPlanID") long mealPlanID) {
        Preconditions.checkNotNull(mealPlanID, "MealPlanID can not be null!");

        Response response;
        boolean success = mealPlanService.removeMealPlan(mealPlanID);
        if (!success) {
            response = Response.status(Response.Status.PRECONDITION_FAILED).build();
        } else {
            response = Response.ok().build();
        }
        return response;
    }
}
