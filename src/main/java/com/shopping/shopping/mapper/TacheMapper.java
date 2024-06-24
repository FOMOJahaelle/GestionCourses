package com.shopping.shopping.mapper;

import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.Dto.TacheRequest;
import com.shopping.shopping.Dto.TacheResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.entyties.Taches;
import org.springframework.stereotype.Service;

@Service
public class TacheMapper {

    public TacheResponse mapToTacheResponse(Taches taches){
        return TacheResponse.builder()
                .nameTache(taches.getNameTache())
                .description(taches.getDescription())
                .statut(taches.getStatut())
               // .course_id(taches.getCourse().getId())
                .build();
    }

    public Taches mapToTache(TacheRequest tache){
        return Taches.builder()
                .nameTache(tache.getNameTache())
                .description(tache.getDescription())
                .statut(tache.getStatut())
                .build();
    }
}
