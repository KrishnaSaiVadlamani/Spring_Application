package com.SpringApplication.SpringApplication.service;

import com.SpringApplication.SpringApplication.dao.StudentRepository;
import com.SpringApplication.SpringApplication.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findStudentById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {

            throw new RuntimeException("Did not find student id - " + theId);
        }

        return theStudent;
    }

    @Override
    public void saveStudent(Student theStudent) {

        studentRepository.save(theStudent);

    }



    @Override
    public void deleteStudentById(int theId) {

        studentRepository.deleteById(theId);

    }

    @Override
    public Student findStudentByEmail(String username)
    {
        return studentRepository.findByEmail(username);
    }

    public boolean studentExists(String email){
        if (findStudentByEmail(email) != null){
            return true;
        }
        return false;
    }

}
