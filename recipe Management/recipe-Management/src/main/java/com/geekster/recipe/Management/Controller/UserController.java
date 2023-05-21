package com.geekster.recipe.Management.Controller;

import com.geekster.recipe.Management.Service.UserService;
import com.geekster.recipe.Management.dto.SignInInput;
import com.geekster.recipe.Management.dto.SignInOutput;
import com.geekster.recipe.Management.dto.SignUpInput;
import com.geekster.recipe.Management.dto.SignUpOutput;
import com.geekster.recipe.Management.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUp ( @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }
    @PostMapping("/signIn")
    public SignInOutput signUp (@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
}
