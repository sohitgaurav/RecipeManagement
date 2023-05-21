package com.geekster.recipe.Management.Controller;

import com.geekster.recipe.Management.Service.CommentService;
import com.geekster.recipe.Management.model.RecipeComment;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/addComment")
    public String  addComment(@RequestBody RecipeComment comment){
        return commentService.addComment(comment);
    }
}
