package com.shopping.shopping.services;

import com.shopping.shopping.entyties.Taches;

import java.util.List;

public interface TacheService {


    Taches getOne (Long id);
    List<Taches> findAll();
    Taches create(Taches tache);
    Taches update(Taches tache,Long id);
    void delete(Long id);


}
