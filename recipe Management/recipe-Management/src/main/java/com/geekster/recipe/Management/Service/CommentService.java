package com.geekster.recipe.Management.Service;

import com.geekster.recipe.Management.model.RecipeComment;
import com.geekster.recipe.Management.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    ICommentRepo commentRepo;

    public String addComment(RecipeComment comment) {
        RecipeComment rComment= commentRepo.save(comment);
        if(rComment==null){
            return "Comment not saved...!";
        }
        else
        {
            return "Comment saved...!";
        }


    }
}
