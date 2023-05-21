package com.geekster.recipe.Management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RecipeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String commentBody;

    @ManyToOne
    @JoinColumn(nullable = false , name = "fk_recipe_ID")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(nullable = false , name = "fk_user_ID")
    private User user;

}
