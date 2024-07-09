package com.shopping.shopping.services;

import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.entyties.Course;

import java.util.List;

public interface CourseService {

    CourseResponse getOne (Long id);
    List<CourseResponse> findAll();
    List<CourseResponse> findByCourseArchivee(Boolean archive);
    List<CourseResponse> findByCourseNonArchive();

  List<CourseResponse> searchByTache(String nameTache);
    CourseResponse create(CourseRequest course);
    CourseResponse update(CourseRequest course,Long id);
    void delete(Long id);
//boolean Archive (CourseResponse course);

   boolean Archive(Long id);
}
