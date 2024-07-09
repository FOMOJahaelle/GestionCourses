package com.shopping.shopping.mapper;

import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.entyties.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {
    // comment utiliser le framework mapStruct a chercher

    public Course mapToCourse(CourseRequest courseRequest){
        return Course.builder()
                .name(courseRequest.getName())
                .description(courseRequest.getDescription())
                .dateCreation(courseRequest.getDateCreation())
                .archive(courseRequest.getArchive())
                .build();
    }

    public CourseResponse mapToCourseResponse(Course course){
        return CourseResponse.builder()
                .name(course.getName())
                .description(course.getDescription())
                .dateCreation(course.getDateCreation())
                .archive(course.getArchive())
                .build();
    }
}
