package com.shopping.shopping.services;

import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.entyties.Taches;
import com.shopping.shopping.mapper.CourseMapper;
import com.shopping.shopping.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {


  private  final  CourseRepository courseRepository;

 // private  final Taches tache;

  private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;

    }

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
    public boolean Archive(Course course) {
//                int j =0;
//                List tache = new ArrayList<>();
//     for(int i=0; i<=course.getTaches().size(); i++)
        for(Taches tache:course.getTaches()){
            if (tache.getStatut()==false) {

                    course.setArchive(false);

            }else {
                course.setArchive(true);
            }
        }
        return course.getArchive();
    }

}
