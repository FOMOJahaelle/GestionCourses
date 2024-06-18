package com.shopping.shopping.services;

import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.repositories.TacheRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {TacheServiceImpl.class})
@ExtendWith(SpringExtension.class)

class   TacheServiceImplTest {
@Autowired
TacheService tacheService;
@MockBean
    TacheRepository tacheRepository;
private Taches taches;
    private Taches tachesUpdate;
    @BeforeEach
    void setUp() {
        taches = new Taches();
        taches.setId(1L);
        taches.setNameTache("analyse et conception");

        List<Taches> tachesList = new ArrayList<>();
        tachesList.add(taches);

    }

    @Test
    void getOne() {
        when(tacheRepository.getOne(taches.getId())).thenReturn(taches);
        Taches taches1 = tacheService.getOne(taches.getId());
        assertNotNull(taches);
        assertEquals(taches1.getId(),taches.getId());

    }

    @Test
    void findAll() {
        //Given
        List<Taches> tachesList = new ArrayList<>();
        tachesList.add(taches);

        Mockito.when(tacheRepository.findAll()).thenReturn(tachesList);
        //When
        assertEquals(1, tachesList.size());
        assertNotNull(tachesList);
    }

    @Test
    void create() {
    when(tacheRepository.save(taches)).thenReturn(taches);
    tacheService.create(taches);
    assertEquals(taches.getId(),1L);
    }

    @Test
    void update() {
        when(tacheRepository.getOne(taches.getId())).thenReturn(taches);
        when(tacheRepository.save(taches)).thenReturn(tachesUpdate);

        tachesUpdate = new Taches();
        tachesUpdate.setId(1L);
        tachesUpdate.setNameTache("specification des besoins");

        Taches result = tacheService.update(tachesUpdate,1L);
        assertEquals(tachesUpdate.getId(),taches.getId());
        assertNotNull(result);
        assertNotNull(taches);
    }

    @Test
    void delete() {
        when(tacheRepository.getOne(taches.getId())).thenReturn(taches);
        tacheService.delete(taches.getId());
        verify(tacheRepository, times(1)).deleteById(taches.getId());
    }
}