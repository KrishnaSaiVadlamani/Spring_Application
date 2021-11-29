package com.springapplication.dto;

import com.springapplication.entity.Course;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class StudentDto
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "is required")
    private String firstName;

    @NotEmpty(message = "is required")
    private String lastName;

    @NotEmpty(message = "is required")
    private String email;

    private String password;

    private List<Course> courses;
}
