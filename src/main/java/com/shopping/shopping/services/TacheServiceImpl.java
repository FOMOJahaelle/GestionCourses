package com.shopping.shopping.services;


import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService{

@Autowired
    TacheRepository tacheRepository;

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
    public Taches create(Taches tache) {
        Taches tache1 = new Taches();
        tache1.setNameTache(tache.getNameTache());
        tache1.setDescription(tache.getDescription());
        tache1.setStatut(tache.getStatut());
        tacheRepository.save(tache1);
        return tache1;
    }

    /**
     * @param tache
     * @param id
     * @return
     */
    @Override
    public Taches update(Taches tache, Long id) {
        Taches tache1 = tacheRepository.getOne(id);
        tache1.setNameTache(tache.getNameTache());
        tache1.setDescription(tache.getDescription());
        tache1.setStatut(tache.getStatut());
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
