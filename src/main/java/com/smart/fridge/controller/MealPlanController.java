package com.smart.fridge.controller;

import com.google.common.base.Preconditions;
import com.smart.fridge.domain.MealAddition;
import com.smart.fridge.domain.MealPlan;
import com.smart.fridge.domain.enums.Day;
import com.smart.fridge.domain.enums.MealTime;
import com.smart.fridge.services.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/rest")
@Component
public class MealPlanController {

    @Autowired
    private MealPlanService mealPlanService;

    /**
     * Returns all meals that are planned for the specific day.
     * @param day Day of the week
     * @return All meals that are planned for the passed day
     */
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

    /**
     * Adds one meal to the MealPlan.
     * @param mealID Meal that should be added
     * @param mealTime Time of day the meal is intended to be consumed
     * @param day Day of the week the meal is intented to be cnsumed
     * @return Respone if succeeded or failed
     */
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

    /**
     * Removes a MealPlan from the database.
     * @param mealPlanID MealPlan that should be removed.
     * @return Response if suceeded or failed.
     */
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

    /**
     * Creates a grocery-list based on the mealplan of the current week.
     * @return Response object containing a List<MealAddition>
     */
    @GET
    @Produces("application/json")
    @Path("/getGroceries")
    public Response getGroceries(){
        Response response;
        List<MealAddition> groceries = _generateGroceries();

        if (groceries.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok().entity(groceries).build();
        }

        return response;
    }

    private List<MealAddition> _generateGroceries(){
        Map<String, MealAddition> groceries = new HashMap<>();

        List<MealPlan> mealPlansOfWeak = new ArrayList<>();
        for (Day day : Day.values()){
            mealPlansOfWeak.addAll(mealPlanService.getMealsOfDay(day));
        }

        List<MealAddition> mealAdditions = new ArrayList<>();
        for (MealPlan mealPlan : mealPlansOfWeak){
            mealAdditions.addAll(mealPlan.getMeal().getMealAdditions());
        }

        for (MealAddition mealAddition : mealAdditions){
            String ingredientName = mealAddition.getIngredient().getName();
            addOrUpdateGrocery(groceries, mealAddition, ingredientName);
        }

        return new ArrayList<>(groceries.values());
    }

    private void addOrUpdateGrocery(Map<String, MealAddition> groceries, MealAddition mealAddition, String ingredientName) {
        if (!groceries.containsKey(ingredientName)){
            groceries.put(ingredientName, mealAddition);
            return;
        }

        MealAddition existingAddition = groceries.get(ingredientName);
        int newValue = existingAddition.getAmount() + mealAddition.getAmount();
        existingAddition.setAmount(newValue);
    }
}
