package com.geekster.recipe.Management.Controller;

import com.geekster.recipe.Management.Service.RecipeService;
import com.geekster.recipe.Management.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;


    @PostMapping("/addRecipe")
    void saveRecipe(@RequestBody Recipe myRecipe){
        recipeService.saveRecipe(myRecipe);
    }
    @GetMapping("/getRecipe/{recipeId}")
    public Recipe getRecipeById(@PathVariable Integer recipeId){
        return recipeService.getRecipeById(recipeId);
    }
     @DeleteMapping("/{recipeId}")
    ResponseEntity<Void> deleteRecipeById(@PathVariable Integer recipeId){
         HttpStatus status;
         try{
             recipeService.removeProductByProductId(recipeId);
             status=HttpStatus.OK;
         }
         catch (Exception e){
             System.out.println(e);
             status=HttpStatus.NOT_ACCEPTABLE;
         }
         return new ResponseEntity<Void>(status);

     }
     }


