package com.shopping.shopping.repositories;

import com.shopping.shopping.entyties.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Taches,Long> {

// retourne un utilisateur a partir de son id

     Taches getOne (Long id);
    // retourne toutes les utilisateurs
   List<Taches> findAll ();
   // retourne un utilisateur a partir de son nom d'utilisateur
   //List<Tache>findByUsersUserName(String userName);


}
