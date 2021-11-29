package com.SpringApplication.SpringApplication.service;

import com.SpringApplication.SpringApplication.dao.CourseRepository;
import com.SpringApplication.SpringApplication.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {

        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(int theId)
    {
        Optional<Course> result = courseRepository.findById(theId);

        Course theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        }
        else {

            throw new RuntimeException("Did not find course id - " + theId);
        }

        return theCourse;
    }

    @Override
    public void saveCourse(Course theCourse) {
         courseRepository.save(theCourse);
    }

    @Override
    public void deleteCourseById(int theId) {
       courseRepository.deleteById(theId);
    }
}
