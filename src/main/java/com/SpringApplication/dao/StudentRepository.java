package com.SpringApplication.dao;

import com.SpringApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {

   public List<Student> findAllByOrderByLastNameAsc();

    @Query("SELECT u FROM Student u WHERE u.email = ?1")
    Student findByEmail(String username);

}
