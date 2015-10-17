package com.smart.fridge.services;

import com.smart.fridge.domain.Ingredient;
import com.smart.fridge.repos.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Transactional
    public String createIngradient() {
        Ingredient ingredient = new Ingredient("BlaBla");
        ingredientRepository.save(ingredient);
        return "Success!";
    }
}
