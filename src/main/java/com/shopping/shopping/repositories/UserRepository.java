package com.shopping.shopping.repositories;

import com.shopping.shopping.Dto.UserDto;
import com.shopping.shopping.entyties.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users getOne (Long id);

    // retourne toutes les utilisateurs
    List<Users> findAll ();


    Optional<Users> findById(Long aLong);

    // retourne un utilisateur a partir de son nom d'utilisateur
  Users findByUserName(String userName);

//   Optional<Users>findByUserName(String userName);
//   Users CreateAccount(UserDto user);


}
