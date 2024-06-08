package com.shopping.shopping.services;

import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.repositories.CourseRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CourseServiceImpl.class})
@ExtendWith(SpringExtension.class)

class CourseServiceImplTest {

    @Autowired
    CourseService courseService;
    @MockBean
    CourseRepository courseRepository;
    private Course course;
    private CourseResponse courseResponse;

    @BeforeEach
    void setUp() {
      course = new Course();
      course.setId(1L);
      course.setName("Cycle de developpement d'un logiciel ");

      courseResponse = new CourseResponse();
      courseResponse.setName("Cycle de developpement d'un logiciel ");


    }

    @Test
    void getOne() {

        when(courseRepository.getOne(course.getId())).thenReturn(course);
        CourseResponse course1 = courseService.getOne(course.getId());
        assertEquals(course.getId(),1L);
        assertNotNull(course1);

    }

    @Test
    void findAll() {
    }

    @Test
    void searchByTache() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}