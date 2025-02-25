package com.shopping.shopping.services;

import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse getOne (Long id);
    List<CourseResponse> findAll();

  List<CourseResponse> searchByTache(String nameTache);
    CourseResponse create(CourseRequest course);
    CourseResponse update(CourseRequest course,Long id);
    void delete(Long id);

}
