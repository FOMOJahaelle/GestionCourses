package com.shopping.shopping.repositories;


import com.shopping.shopping.entyties.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CourseRepository extends JpaRepository <Course,Long>{


// retourne une course a partir de son id
//    public Course findById (Long id);

     Course getOne (Long id);
// retourne les courses qui ont une tache passe en parametre
     List<Course> findByTachesNameTache (String nomTache);

}
