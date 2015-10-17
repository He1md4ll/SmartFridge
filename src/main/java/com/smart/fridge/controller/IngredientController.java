package com.smart.fridge.controller;

import com.smart.fridge.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/rest")
@Component
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GET
    @Path("/createIngredient")
    @Produces("application/json")
    public String createIngredient() {
        return ingredientService.createIngradient();
    }
}
