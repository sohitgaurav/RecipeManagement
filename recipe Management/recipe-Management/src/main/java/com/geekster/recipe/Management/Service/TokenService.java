package com.geekster.recipe.Management.Service;

import com.geekster.recipe.Management.model.AuthenticationToken;
import com.geekster.recipe.Management.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    ITokenRepo tokenRepo;
    public void saveToken(AuthenticationToken token)
    {
        tokenRepo.save(token);
    }
}
