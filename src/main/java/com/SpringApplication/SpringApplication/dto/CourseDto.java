package com.SpringApplication.SpringApplication.dto;

import com.SpringApplication.SpringApplication.entity.Course;
import com.SpringApplication.SpringApplication.entity.Student;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class CourseDto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String title;

    private List<Student> students;

}
