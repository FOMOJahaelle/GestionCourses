package com.shopping.shopping.controllers;

import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.repositories.TacheRepository;
import com.shopping.shopping.services.TacheService;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(controllers = TacheController.class)
class TacheControllerTest {
//    https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TacheService tacheService;

    @InjectMocks
            TacheController tacheController;

    @Mock
    TacheRepository tacheRepository;

    @BeforeEach
    void setUp() {
//        tacheService.create(new Taches(1L, "tache1", "ma premiere tache",false));
    Taches taches = new Taches();
    taches.setId(1L);
    taches.setNameTache("tache1");

        List<Taches> tachesList = new ArrayList<>();
        tachesList.add(taches);
    }

    @Test
    public void createTache()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(tacheService.create(any(Taches.class))).thenReturn(new Taches());

        Taches taches = new Taches(1L, "tache1", "ma premiere tache",false);
        Taches tache = tacheController.createTache(taches);

//        assertThat(statut().isEqualTo(201));
//        assertThat(tache.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

//    @Test
//    void createTache() {
//
//
//    }

    @Test
    void getOne() {
    }

    @Test
    void updateCourse() {
    }
    @Test
    public void testFindAll() {
        Taches tache1 = new Taches(1L, "tache1", "ma premiere tache",false);
        Taches tache2 = new Taches(2L, "tache2", "ma deuxieme tache", true);
        List<Taches> tachesLists = new ArrayList<>();
        tachesLists.add(tache1);
        tachesLists.add(tache2);
        when(tacheRepository.findAll()).thenReturn(tachesLists);
//        List<Taches> result = tacheController.tacheList();
        assertNotNull(tachesLists);
//        assertNotNull(result.size());
//        assertEquals(tachesLists.size(),2);


    }



//    @Test
//    void tacheList() {
//    }

    @Test
    void deleteTacheById() {
    }
}