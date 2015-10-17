package com.smart.fridge;

import com.smart.fridge.controller.IngredientController;
import com.smart.fridge.controller.MealController;
import com.smart.fridge.controller.MealPlanController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(MealController.class);
        register(IngredientController.class);
        register(MealPlanController.class);
    }
}

