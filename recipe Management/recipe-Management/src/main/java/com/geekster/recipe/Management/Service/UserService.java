package com.geekster.recipe.Management.Service;

import com.geekster.recipe.Management.dto.SignInInput;
import com.geekster.recipe.Management.dto.SignInOutput;
import com.geekster.recipe.Management.dto.SignUpInput;
import com.geekster.recipe.Management.dto.SignUpOutput;
import com.geekster.recipe.Management.model.AuthenticationToken;
import com.geekster.recipe.Management.model.User;
import com.geekster.recipe.Management.repository.ITokenRepo;
import com.geekster.recipe.Management.repository.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    TokenService tokenService;
    @Autowired
    ITokenRepo tokenRepo;

    public SignUpOutput signUp(User signUpDto) {


        //check if user exists or not based on email
        User user = userRepo.findFirstByUserEmail(signUpDto.getUserEmail());

        if (user != null) {
            throw new IllegalStateException("Instagram user already exists!!!!...sign in instead");
        }

//      encryption
        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        signUpDto.setUserPassword(encryptedPassword);
        userRepo.save(signUpDto);

        return new SignUpOutput(" user registered", "user account created successfully");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;


    }

    public SignInOutput signIn(SignInInput signInDto) {
        //check if user exists or not based on email
        User user = userRepo.findFirstByUserEmail(signInDto.getUserEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getUserPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());


    }
}

