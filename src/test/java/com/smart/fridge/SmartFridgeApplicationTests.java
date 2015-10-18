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

    private List<Ingredient> ingredients;
    private List<MealAddition> mealAdditions;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MealAdditionRepository mealAdditionRepository;

    @Autowired
    private MealRepository mealRepository;

    @Before
    public void setUp() {
        createIngredients();
    }

    @Test
    public void createMeals() {
        mealAdditions = new ArrayList<>();
        mealAdditions.add(new MealAddition(80, ingredients.get(0)));
        mealAdditions.add(new MealAddition(500, ingredients.get(1)));
        mealAdditions.add(new MealAddition(130, ingredients.get(2)));
        mealAdditions.add(new MealAddition(5, ingredients.get(3)));
        mealAdditions.add(new MealAddition(5, ingredients.get(4)));
        mealAdditionRepository.save(mealAdditions);
        Meal meal = new Meal("Pancakes",mealAdditions);
        mealRepository.save(meal);

        mealAdditions = new ArrayList<>();
        mealAdditions.add(new MealAddition(100, ingredients.get(5)));
        mealAdditions.add(new MealAddition(300, ingredients.get(6)));
        mealAdditions.add(new MealAddition(200, ingredients.get(7)));
        mealAdditionRepository.save(mealAdditions);
        meal = new Meal("RiceBroccoliChickenMeal",mealAdditions);
        mealRepository.save(meal);

        mealAdditions = new ArrayList<>();
        mealAdditions.add(new MealAddition(2, ingredients.get(8)));
        mealAdditions.add(new MealAddition(300, ingredients.get(9)));
        mealAdditionRepository.save(mealAdditions);
        meal = new Meal("Honey bread",mealAdditions);
        mealRepository.save(meal);

        mealAdditions = new ArrayList<>();
        mealAdditions.add(new MealAddition(2, ingredients.get(8)));
        mealAdditions.add(new MealAddition(2, ingredients.get(10)));
        mealAdditionRepository.save(mealAdditions);
        meal = new Meal("Cheese bread",mealAdditions);
        mealRepository.save(meal);

        mealAdditions = new ArrayList<>();
        mealAdditions.add(new MealAddition(0, ingredients.get(1)));
        mealAdditions.add(new MealAddition(40, ingredients.get(2)));
        mealAdditions.add(new MealAddition(1, ingredients.get(10)));
        mealAdditions.add(new MealAddition(400, ingredients.get(4)));
        mealAdditions.add(new MealAddition(21, ingredients.get(5)));
        mealAdditionRepository.save(mealAdditions);
        meal = new Meal("I wont eat that",mealAdditions);
        mealRepository.save(meal);

        mealAdditions = new ArrayList<>();
        mealAdditions.add(new MealAddition(2000, ingredients.get(7)));
        mealAdditionRepository.save(mealAdditions);
        meal = new Meal("Chicken chickens",mealAdditions);
        mealRepository.save(meal);
    }

    private void createIngredients() {
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Sugar", Unit.G));
        ingredients.add(new Ingredient("Flour", Unit.G));
        ingredients.add(new Ingredient("Milk", Unit.KG));
        ingredients.add(new Ingredient("Egg", Unit.PIECE));
        ingredients.add(new Ingredient("Vanilla Sugar", Unit.G));

        ingredients.add(new Ingredient("Rice", Unit.G));
        ingredients.add(new Ingredient("Broccoli", Unit.G));
        ingredients.add(new Ingredient("Chicken", Unit.G));

        ingredients.add(new Ingredient("Bread", Unit.PIECE));
        ingredients.add(new Ingredient("Honey", Unit.G));
        ingredients.add(new Ingredient("Cheese", Unit.PIECE));

        ingredientRepository.save(ingredients);
    }
}
