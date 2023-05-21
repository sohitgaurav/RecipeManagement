package com.geekster.recipe.Management.repository;

import com.geekster.recipe.Management.model.RecipeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends JpaRepository<RecipeComment,Integer> {
}
