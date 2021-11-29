package com.SpringApplication.SpringApplication.service;

import com.SpringApplication.SpringApplication.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStudents();

    public Student findStudentById(int theId);

    public void saveStudent(Student theStudent);


    public void deleteStudentById(int theId);

    Student findStudentByEmail(String username);

    public boolean studentExists(String email);

}
