package com.shopping.shopping.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class CourseRequest {

    private String name;
    private String description;
    private Date dateCreation;
}
