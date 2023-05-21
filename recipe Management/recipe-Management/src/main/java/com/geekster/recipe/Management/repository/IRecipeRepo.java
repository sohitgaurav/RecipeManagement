package com.geekster.recipe.Management.repository;

import com.geekster.recipe.Management.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecipeRepo extends JpaRepository<Recipe,Integer> {

    Recipe findByRecipeId(Integer recipeId);
}
