package com.shopping.shopping.repositories;

import com.shopping.shopping.entyties.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users getOne (Long id);
    // retourne toutes les utilisateurs
    List<Users> findAll ();
    // retourne un utilisateur a partir de son nom d'utilisateur
    List<Users>findByUserName(String userName);

}
