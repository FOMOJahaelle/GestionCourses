package com.shopping.shopping.services;

import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.mapper.CourseMapper;
import com.shopping.shopping.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.lang.annotation.Before;
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

@ContextConfiguration(classes = {CourseServiceImpl.class})
@ExtendWith(SpringExtension.class)

class CourseServiceImplTest {

    @Autowired
    CourseService courseService;


    @MockBean
    CourseRepository courseRepository;
    @MockBean
    CourseMapper courseMapper;

    private Taches taches;
    private Course course;
    private CourseResponse courseResponse;
    private CourseRequest courseRequest;
    private  CourseResponse courseUpdate;
//    private CourseMapper courseMapper;

    @BeforeEach
    void setUp() {
      course = new Course();
      course.setId(1L);
      course.setName("Cycle de developpement d'un logiciel ");

      courseResponse = new CourseResponse();
      courseResponse.setName("Cycle de developpement d'un logiciel ");

      courseRequest = new CourseRequest();
      courseRequest.setDescription("Cycle de developpement d'un logiciel");

      taches = new Taches().builder()
              .nameTache("analyse")
              .description("reccueille des besoins")
              .statut(false)
              .build();

courseUpdate = new CourseResponse();
courseUpdate.setName("projet de developpement d'un logiciel de gestion des courses");

    }

    @Test
    void getOne() {

        when(courseRepository.findById(course.getId())
                .map(courseMapper::mapToCourseResponse)
                .orElseThrow(()->new EntityNotFoundException("Not Course found with id : " +course.getId())))
                .thenReturn(courseResponse);
        assertNotNull(courseResponse);
        assertEquals(course.getId(),1L);

    }


    @Test
    void findAll() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        courseResponseList.add(courseResponse);
        Mockito.when(courseRepository.findAll().stream()
                .map(courseMapper::mapToCourseResponse)
                .toList()
        ).thenReturn(courseResponseList);

        assertNotNull(courseResponseList);
        assertEquals(courseResponseList.size(),1);

    }


    @Test
    void searchByTache() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        courseResponseList.add(courseResponse);
        Mockito.when(courseRepository.findByTachesNameTache(taches.getNameTache()).stream()
                .map(courseMapper::mapToCourseResponse)
                .toList()).thenReturn(courseResponseList);
        assertNotNull(courseResponseList);

    }

    @Test
    void create() {
         when(courseRepository.save(course)).thenReturn(course);
         courseService.create(courseRequest);
         assertEquals(course.getId(),1L);
    }

//    @Test
//    void update() {
//        when(tacheRepository.getOne(taches.getId())).thenReturn(taches);
//        when(tacheRepository.save(taches)).thenReturn(tachesUpdate);
//
//        tachesUpdate = new Taches();
//        tachesUpdate.setId(1L);
//        tachesUpdate.setNameTache("specification des besoins");
//
//        Taches result = tacheService.update(tachesUpdate,1L);
//        assertEquals(tachesUpdate.getId(),taches.getId());
//        assertNotNull(result);
//        assertNotNull(taches);
//    }

    @Test
    void update() {
        when(courseRepository.getOne(course.getId())).thenReturn(course);
        when(courseRepository.save(course)).thenReturn(course);

        CourseResponse response = courseService.update(courseRequest,course.getId());
        assertNotNull(response);
        assertNotNull(course);
    }

    @Test
    void delete() {
        when(courseRepository.getOne(course.getId())).thenReturn(course);
        courseService.delete(course.getId());
        verify(courseRepository,times(1)).deleteById(course.getId());
    }
}