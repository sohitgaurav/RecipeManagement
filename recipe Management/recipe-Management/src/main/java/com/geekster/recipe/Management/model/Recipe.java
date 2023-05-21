package com.geekster.recipe.Management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    @NotEmpty
    private String  recipeName;
    @NotEmpty
    private String recipeIngredient;
    @NotEmpty
    private String recipeInstruction;
}
