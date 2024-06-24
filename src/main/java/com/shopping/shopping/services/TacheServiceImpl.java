package com.shopping.shopping.services;


import com.shopping.shopping.Dto.TacheDto;
import com.shopping.shopping.Dto.TacheRequest;
import com.shopping.shopping.Dto.TacheResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.mapper.TacheMapper;
import com.shopping.shopping.repositories.CourseRepository;
import com.shopping.shopping.repositories.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService{


 private final   TacheRepository tacheRepository;
private final CourseRepository courseRepository;
private  final TacheMapper tacheMapper;

    public TacheServiceImpl(TacheRepository tacheRepository, CourseRepository courseRepository, TacheMapper tacheMapper) {
        this.tacheRepository = tacheRepository;
        this.courseRepository = courseRepository;
        this.tacheMapper = tacheMapper;
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
    public Taches create (TacheDto tache, Long id) {
       Taches taches = new Taches();
        Course course = courseRepository.getOne(id);
        taches.setNameTache(tache.getNameTache());
        taches.setDescription(tache.getDescription());
        taches.setStatut(tache.getStatut());
        taches.setCourse(course);
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
