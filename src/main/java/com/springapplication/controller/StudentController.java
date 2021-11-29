package com.springapplication.controller;

import com.springapplication.config.StudentUserDetails;
import com.springapplication.converter.CourseConverter;
import com.springapplication.converter.StudentConverter;
import com.springapplication.dto.CourseDto;
import com.springapplication.dto.StudentDto;
import com.springapplication.service.CourseService;
import com.springapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    private String studentAttribute="student";

    @GetMapping("/list")
    public String listStudents(Model theModel){

        StudentConverter studentConverter=new StudentConverter();

        List<StudentDto> studentDtos= studentConverter.entityToDto(studentService.findAllStudents());


        theModel.addAttribute("students",studentDtos);

        return "student/list-students";

    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdateStudent(@RequestParam("studentId") int theId,
                                    Model theModel) {

        StudentDto studentDto=new StudentConverter().entityToDto(studentService.findStudentById(theId));


        theModel.addAttribute(studentAttribute, studentDto);

        CourseConverter courseConverter=new CourseConverter();
        List<CourseDto> courseDtos= courseConverter.entityToDto(courseService.findAllCourses());

        theModel.addAttribute("theCourse",courseDtos);


        return "student/student-update-form";
    }


    @GetMapping("/showMyPage")
    public String showMyPageStudent(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        StudentUserDetails userDetails = (StudentUserDetails)auth.getPrincipal();
        String emailId = userDetails.getUsername();
        StudentDto studentDto=new StudentConverter().entityToDto(studentService.findStudentByEmail(emailId));
        model.addAttribute(studentAttribute,studentDto);
        return "student-page";
    }


    @GetMapping("/showAccount")
    public String showStudentAccountPage(@RequestParam("studentId") int id,Model model){
        StudentConverter studentConverter=new StudentConverter();
        StudentDto studentDto= studentConverter.entityToDto(studentService.findStudentById(id));
        model.addAttribute(studentAttribute,studentDto);
        return "student/account-page";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentDto studentDto
    ){
        StudentConverter studentConverter=new StudentConverter();

        studentService.saveStudent(studentConverter.dtoToEntity(studentDto));

        return "student/update-success";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int theId){
        studentService.deleteStudentById(theId);

        return "redirect:/students/list";
    }

}
