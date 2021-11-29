package com.SpringApplication.converter;

import com.SpringApplication.dto.CourseDto;
import com.SpringApplication.entity.Course;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter {

    public CourseDto entityToDto(Course course)
    {
        ModelMapper mapper=new ModelMapper();
        CourseDto map=mapper.map(course,CourseDto.class);
        return map;
    }
    public Course dtoToEntity(CourseDto courseDto)
    {
        ModelMapper mapper=new ModelMapper();
        Course map=mapper.map(courseDto,Course.class);
        return map;
    }
    public List<CourseDto> entityToDto(List<Course> courses)
    {
        return  courses.stream().map(x->entityToDto(x)).collect(Collectors.toList());

    }
    public List<Course> dtoToEntity(List<CourseDto> courseDtoList){

        return courseDtoList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
