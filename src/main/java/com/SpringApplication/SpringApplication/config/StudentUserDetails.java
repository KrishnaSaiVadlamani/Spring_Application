package com.SpringApplication.SpringApplication.config;

import com.SpringApplication.SpringApplication.entity.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

    public class StudentUserDetails implements UserDetails {

        private Student student;

        public StudentUserDetails(Student student) {
            this.student=student;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return student.getPassword();
        }

        @Override
        public String getUsername() {
            return student.getEmail();
        }


        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
