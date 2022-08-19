package nl.angeltr.cannolisrruffino.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

   @GetMapping
   public List<Ingredient> getAllIngredients() {
        var ingredients = new ArrayList<Ingredient>();
        var allIngredients = ingredientsService.getAllIngredients();

        for (Ingredient singleIngredient : allIngredients) {
            ingredients.add(singleIngredient);
        }
        return ingredients;
    }

    @GetMapping("/{id}")
    public Ingredient getIngredients(@PathVariable("id") Long id) {
        var ingredients = ingredientsService.getIngredients(id);
        return ingredients;
    }
    @PostMapping
    public Ingredient saveIngredients(@RequestBody Ingredient ingredientOne) {
        var ingredients = ingredientsService.saveIngredients(ingredientOne);
        return ingredients;
    }
    @PostMapping("/save_ingredients")
    public Ingredient addIngredients(@RequestBody IngredientsRequest ingredientsRequest) {
        return ingredientsService.addIngredients(ingredientsRequest);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Object> deleteIngredients(@PathVariable("id") Long id) throws IOException {
        ingredientsService.deleteIngredients(id);
        return ResponseEntity.noContent().build();
    }
}





