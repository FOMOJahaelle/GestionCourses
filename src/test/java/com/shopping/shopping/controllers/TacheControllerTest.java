package com.shopping.shopping.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.repositories.TacheRepository;
import com.shopping.shopping.services.TacheService;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = TacheController.class)
@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)

class TacheControllerTest {
//    https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MockMvc mvc;
    @MockBean
     TacheController tacheController;
    @MockBean
    private TacheService tacheService;

    @Autowired
    private ObjectMapper objectMapper;

//    @InjectMocks
//            TacheController tacheController;

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
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        when(tacheService.create(any(Taches.class))).thenReturn(new Taches());
//
//        Taches taches = new Taches(1L, "tache1", "ma premiere tache",false);
//        Taches tache = tacheController.createTache(taches);

//        assertThat(statut().isEqualTo(201));
//        assertThat(tache.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

//    @Test
//    void createTache() {
//
//    }
    @Test
    void getOne() throws Exception {
//        Taches taches = new Taches();
//        taches.setId(1L);
//        taches.setNameTache("tache1");
//        taches.setDescription("ma premiere tache");
//        taches.setStatut(false);
//
//        // Define the taches ID for the test
//        Long tachesId=1L;
//
//        // Mocking the service behavior to return an Optional containing a specific tache instance
//        when(tacheService.getOne(tachesId)).thenReturn(taches);
//
//        // Performing an HTTP GET request to retrieve an tache by ID
//        ResultActions response = mockMvc.perform(get("/api/tache/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(taches)));
//
//        // Asserting the response expectations
//        response.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.nameTache", CoreMatchers.is(taches.getNameTache())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.description", CoreMatchers.is(taches.getDescription())));

    }


    @Test
    void updateTache() {
    }
    @Test
    public void testFindAll() {
//
//        Taches tache1 = new Taches(1L, "tache1", "ma premiere tache",false);
//        Taches tache2 = new Taches(2L, "tache2", "ma deuxieme tache", true);
//        List<Taches> tachesLists = new ArrayList<>();
//        tachesLists.add(tache1);
//        tachesLists.add(tache2);
//        when(tacheRepository.findAll()).thenReturn(tachesLists);
//        List<Taches> result = tacheController.tacheList();
//        assertNotNull(tachesLists);
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