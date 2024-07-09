package com.shopping.shopping.services;

import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.mapper.CourseMapper;
import com.shopping.shopping.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {


  private  final  CourseRepository courseRepository;

 // private  final Taches tache;

  private final CourseMapper courseMapper;

    @Override
    public CourseResponse getOne(Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::mapToCourseResponse)
                .orElseThrow(()->new EntityNotFoundException("Not Course found with id : " +id));
    }

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::mapToCourseResponse)
                .toList();
    }

    @Override
    public List<CourseResponse> findByCourseArchivee(Boolean archive) {
        List <CourseResponse> courseResponses = new ArrayList<>();
       List<CourseResponse> courses = courseRepository.findAll().stream()
               .map(courseMapper::mapToCourseResponse)
               .toList();
       for(CourseResponse course:courses){
           if(course.getArchive()==archive){
               courseResponses.add(course);
           }
//           return courseResponses;
       }
        return courseResponses;
    }

    @Override
    public List<CourseResponse> findByCourseNonArchive() {
        return null;
    }

    @Override
    public List<CourseResponse> searchByTache(String nameTache) {
        return courseRepository.findByTachesNameTache(nameTache).stream()
                .map(courseMapper::mapToCourseResponse)
                .toList();
    }

    @Override
    public CourseResponse create(CourseRequest course) {
    Course course1 = courseMapper.mapToCourse(course);
        return courseMapper.mapToCourseResponse(courseRepository.save(course1));
    }

    @Override
    public CourseResponse update(CourseRequest course,Long id) {
        Course course1 = courseRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Not Course found with id : " +id));
        courseMapper.mapToCourse(course);
        return courseMapper.mapToCourseResponse(courseRepository.save(course1));
    }

    @Override
    public void delete(Long id) {

        courseRepository.deleteById(id);
    }

    @Override
//    public boolean Archive(Course course) {
////   Optional<Course> course = courseRepository.findById(id);
////
////
//        for(Taches tache:course.getTaches()){
//            if (!tache.getStatut()) {
//
////                    course.setArchive(false);
//
//
//            }else {
//                course.setArchive(true);
//            }
//        }
//        return course.getArchive();
//    }

    public boolean Archive(Long id) {
    Optional<Course> course = courseRepository.findById(id);

        for(Taches tache:course.get().getTaches()){
            if (!tache.getStatut()) {

//                    course.setArchive(false);
                course.get().setArchive(false);

            }else {
                course.get().setArchive(true);
            }
        }
        return course.get().getArchive();
    }
}
