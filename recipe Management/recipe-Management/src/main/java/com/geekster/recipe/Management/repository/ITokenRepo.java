package com.geekster.recipe.Management.repository;

import com.geekster.recipe.Management.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken,Integer> {
}
