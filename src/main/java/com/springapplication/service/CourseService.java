package com.springapplication.service;

import com.springapplication.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();

    Course findCourseById(int theId) throws Exception;

    void saveCourse(Course theCourse);

    void deleteCourseById(int theId);

}
