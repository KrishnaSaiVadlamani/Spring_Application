package com.springapplication.converter;

import com.springapplication.dto.StudentDto;
import com.springapplication.entity.Student;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public class StudentConverter {

        public StudentDto entityToDto(Student student)
        {
                ModelMapper mapper=new ModelMapper();
                return mapper.map(student,StudentDto.class);

        }
        public Student dtoToEntity(StudentDto studentDto)
        {
                ModelMapper mapper=new ModelMapper();
                return mapper.map(studentDto,Student.class);

        }
        public List<StudentDto> entityToDto(List<Student> students)
        {
                return  students.stream().map(this::entityToDto).collect(Collectors.toList());

        }
        public List<Student> dtoToEntity(List<StudentDto> studentDtoList){

                return studentDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
        }


}


