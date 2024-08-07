package com.shopping.shopping.services;

import com.shopping.shopping.Dto.TacheDto;
import com.shopping.shopping.Dto.TacheRequest;
import com.shopping.shopping.Dto.TacheResponse;
import com.shopping.shopping.entyties.Taches;

import java.util.List;

public interface TacheService {

    TacheDto save(TacheDto tache);
    Taches getOne (Long id);
    List<Taches> findAll();
 TacheDto create(TacheDto tache, Long id);
//TacheDto create(TacheDto tache);
//   TacheResponse create(TacheRequest tacheRequest);
    Taches update(TacheDto tache,Long id);
    void delete(Long id);


}
