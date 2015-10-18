package com.smart.fridge;

import com.smart.fridge.domain.Ingredient;
import com.smart.fridge.domain.Meal;
import com.smart.fridge.domain.MealAddition;
import com.smart.fridge.domain.enums.Unit;
import com.smart.fridge.repos.IngredientRepository;
import com.smart.fridge.repos.MealAdditionRepository;
import com.smart.fridge.repos.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmartFridgeApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class SmartFridgeApplicationTests {

    private Ingredient ingredient;
    private Meal meal;
    private MealAddition mealAddition;
    private List<MealAddition> mealAdditionList;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MealAdditionRepository mealAdditionRepository;

    @Autowired
    private MealRepository mealRepository;

    @Before
    public void setUp() {


        mealAdditionList = new ArrayList<>();
        mealAddition = new MealAddition(300, ingredient);
        mealAdditionList.add(mealAddition);
        mealAddition = new MealAddition(300, ingredient);
        mealAdditionList.add(mealAddition);

        meal = new Meal("Pancakes", mealAdditionList);
    }

    @Test
    public void createMeal() {
        ingredientRepository.save(ingredient);
        mealAdditionRepository.save(mealAddition);
        mealRepository.save(meal);
    }

    private void createIngredient(String name) {
        ingredient = new Ingredient("Sugar", Unit.G);
        ingredientRepository.save(ingredient);
        ingredient = new Ingredient("Flour", Unit.G);
        ingredientRepository.save(ingredient);
        ingredient = new Ingredient("Egg", Unit.PIECE);
        ingredientRepository.save(ingredient);
        ingredient = new Ingredient("Milk", Unit.KG);
        ingredientRepository.save(ingredient);
        ingredient = new Ingredient("Vanilla Sugar", Unit.KG);
        ingredientRepository.save(ingredient);
    }

    private void create() {
    }

}
