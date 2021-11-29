package com.SpringApplication.SpringApplication.service;

import com.SpringApplication.SpringApplication.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();

    Course findCourseById(int theId);

    public void saveCourse(Course theCourse);

    public void deleteCourseById(int theId);

}
