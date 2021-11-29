package com.SpringApplication.SpringApplication.dao;

import com.SpringApplication.SpringApplication.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {


}
