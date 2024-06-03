package com.shopping.shopping.controllers;


import com.shopping.shopping.Dto.CourseRequest;
import com.shopping.shopping.Dto.CourseResponse;
import com.shopping.shopping.entyties.Course;
import com.shopping.shopping.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

private  final CourseService courseService;

    public CourseController(CourseService courseService) {

        this.courseService = courseService;
    }

    @Operation(summary = "creer une course", description = "Creer une course ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course Cree",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Course.class))}),
            @ApiResponse(responseCode = "400", description = "la course existe deja.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})

    })
    @PostMapping("/create")
    public CourseResponse createCourse(@RequestBody @Valid CourseRequest course) {
        return courseService.create(course);

    }

    @Operation(summary = "obtenir une course", description = "Obtenir une course a partir de son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Course.class))}),
            @ApiResponse(responseCode = "4004", description = "nous ne retrouvons aucune course a partir de cet idenfiant.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/{id}")
    public CourseResponse getOne(@PathVariable("id") Long id) {

        return courseService.getOne(id);
    }

    @Operation(summary = "Modifier une course", description = "Modifier une course a partir de son identifianr")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course Modifiée",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Course.class))}),
            @ApiResponse(responseCode = "404", description = "Nous ne retrouvons pas la course a partir de cette identifiant.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})

    })
    @PutMapping("/{id}")
    public CourseResponse updateCourse(@RequestBody @Valid CourseRequest course, @PathVariable Long id) {
        return courseService.update(course,id);
    }


    @Operation(summary = "Lister les courses", description = "Recuperer la liste de toutes les courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des courses",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Course.class)))})

    })
    @GetMapping("/all")
    public List<CourseResponse> courseList(){

        return courseService.findAll();
    }


    @Operation(summary = "Supprimer une course", description = " supprimer une course a partir de son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course suppimée avec succes"),
            @ApiResponse(responseCode = "404", description = "Nous ne trouvons pas la course avec cet idenfiant.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })
    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable("id") Long id) {

        courseService.delete(id);
    }



}
