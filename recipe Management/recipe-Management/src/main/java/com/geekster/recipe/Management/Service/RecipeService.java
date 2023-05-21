package com.geekster.recipe.Management.Service;

import com.geekster.recipe.Management.model.Recipe;
import com.geekster.recipe.Management.repository.IRecipeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    IRecipeRepo recipeRepo;

    public void saveRecipe(Recipe myRecipe) {
        recipeRepo.save(myRecipe);
    }

    public Recipe getRecipeById(Integer recipeId) {
        return recipeRepo.findByRecipeId(recipeId);
    }

    public void removeProductByProductId(Integer recipeId) {
        //check if present
        boolean isPresent= recipeRepo.existsById(recipeId);
        //delete
        if(isPresent){
            recipeRepo.deleteById(recipeId);
        }
        //exception
        else{
            throw new EntityNotFoundException("id is not valid for deletion  ");
        }

    }
}
