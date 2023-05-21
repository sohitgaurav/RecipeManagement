package com.geekster.recipe.Management.repository;


import com.geekster.recipe.Management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IUserRepo extends JpaRepository<User,Integer> {


    User findFirstByUserEmail(String email);
}
