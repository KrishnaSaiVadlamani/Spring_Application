package com.SpringApplication.converter;

import com.SpringApplication.dto.StudentDto;
import com.SpringApplication.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

        public StudentDto entityToDto(Student student)
        {
                ModelMapper mapper=new ModelMapper();
                StudentDto map=mapper.map(student,StudentDto.class);
                return map;
        }
        public Student dtoToEntity(StudentDto studentDto)
        {
                ModelMapper mapper=new ModelMapper();
                Student map=mapper.map(studentDto,Student.class);
                return map;
        }
        public List<StudentDto> entityToDto(List<Student> students)
        {
                return  students.stream().map(x->entityToDto(x)).collect(Collectors.toList());

        }
        public List<Student> dtoToEntity(List<StudentDto> studentDtoList){

                return studentDtoList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
        }


}


