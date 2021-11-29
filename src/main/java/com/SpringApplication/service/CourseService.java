package com.SpringApplication.service;

import com.SpringApplication.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();

    Course findCourseById(int theId) throws Exception;

    public void saveCourse(Course theCourse);

    public void deleteCourseById(int theId);

}
