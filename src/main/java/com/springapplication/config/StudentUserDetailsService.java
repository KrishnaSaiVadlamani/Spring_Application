package com.springapplication.config;

import com.springapplication.entity.Student;
import com.springapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

    public class StudentUserDetailsService implements UserDetailsService {

        @Autowired
        private StudentService studentService;

        @Override
        public UserDetails loadUserByUsername(String username){
            Student student = studentService.findStudentByEmail(username);
            if (student == null) {
                throw new UsernameNotFoundException("User not found");
            }

            return new StudentUserDetails(student);
        }

    }

