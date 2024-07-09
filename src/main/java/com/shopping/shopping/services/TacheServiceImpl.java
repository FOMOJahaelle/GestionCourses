package com.shopping.shopping.services;


import com.shopping.shopping.Dto.TacheDto;
import com.shopping.shopping.Dto.TacheRequest;
import com.shopping.shopping.Dto.TacheResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.mapper.TacheMapper;
import com.shopping.shopping.repositories.CourseRepository;
import com.shopping.shopping.repositories.TacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class TacheServiceImpl implements TacheService{


 private final   TacheRepository tacheRepository;
private final CourseRepository courseRepository;
private  final TacheMapper tacheMapper;

    @Override
    public TacheDto save(TacheDto tache) {
        return tacheRepository.save(tache);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Taches getOne(Long id) {

        return tacheRepository.getOne(id);
    }

    /**
     * @return
     */
    @Override
    public List<Taches> findAll() {
        return tacheRepository.findAll();
    }

    /**
     * @param tache
     * @return
     */
    @Override
    public TacheDto create (TacheDto tache, Long id) {
       TacheDto taches = new TacheDto();
        Course course = courseRepository.getOne(id);
        Long idc = course.getId();
        taches.setNameTache(tache.getNameTache());
        taches.setDescription(tache.getDescription());
        taches.setStatut(tache.getStatut());
        taches.setCourse_id(idc);
        return  tacheRepository.save(taches);


    }

//    public TacheResponse create (TacheRequest tache) {
//        Taches taches1 = tacheMapper.mapToTache(tache);
//        return tacheMapper.mapToTacheResponse(tacheRepository.save(taches1));
//
//    }

    /**
     * @param tache
     * @param id
     * @return
     */
    @Override
    public Taches update(TacheDto tache, Long id) {
        Taches tache1 = tacheRepository.getOne(id);
//        Course course = courseRepository.getOne(id);
        tache1.setNameTache(tache.getNameTache());
        tache1.setDescription(tache.getDescription());
        tache1.setStatut(tache.getStatut());

//   tache1.setCourse(course);
        tacheRepository.save(tache1);
        return tache1;
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {

        tacheRepository.deleteById(id);
    }
}
