package com.smart.fridge.controller;

import com.smart.fridge.domain.Ingredient;
import com.smart.fridge.domain.enums.Unit;
import com.smart.fridge.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/rest")
@Component
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private CustomResponseBuilder customResponseBuilder;

    @GET
    @Path("/createIngredient")
    @Produces("application/json")
    public Response createIngredient(@QueryParam(value = "ingredientName") String ingredientName, @QueryParam(value = "ingredientUnit") Unit ingredientUnit) {
        Response response;
        Ingredient ingredient = ingredientService.createIngradient(ingredientName, ingredientUnit);
        if (ingredient == null) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(ingredient).build();
        }
        return customResponseBuilder.buildCustomResponse(response);

    }
}
