package com.SpringApplication.controller;

import com.SpringApplication.converter.CourseConverter;
import com.SpringApplication.dto.CourseDto;
import com.SpringApplication.entity.Student;
import com.SpringApplication.service.CourseService;
import com.SpringApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

        public void initBinder(WebDataBinder dataBinder){
            StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
            dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
        }

        @Autowired
        private StudentService studentService;

        @Autowired
        private CourseService courseService;

        @GetMapping("/login")
        public String login(){
            return "login";
        }

        @GetMapping("/")
        public String viewHomePage(){
            return "home-page";
        }

        @GetMapping("/showRegistrationPage")
        public String showRegistrationForm(Model model) {
            model.addAttribute("student", new Student());

            CourseConverter courseConverter=new CourseConverter();

            List<CourseDto> courseDtos= courseConverter.entityToDto(courseService.findAllCourses());

            model.addAttribute("courses",courseDtos);

            return "signup-form";
        }

        @PostMapping("/register")
        public String processRegister(@Valid Student student, BindingResult bindingResult) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(student.getPassword());
            student.setPassword(encodedPassword);

            if (studentService.studentExists(student.getEmail())){
                throw new RuntimeException("Email Already exists");
            }

            if (bindingResult.hasErrors()){
                return "signup-form";
            }
            studentService.saveStudent(student);

            return "register-success";
        }


}

