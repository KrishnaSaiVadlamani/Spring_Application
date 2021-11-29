package com.springapplication.converter;

import com.springapplication.dto.CourseDto;
import com.springapplication.entity.Course;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public class CourseConverter {

    public CourseDto entityToDto(Course course)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(course,CourseDto.class);

    }
    public Course dtoToEntity(CourseDto courseDto)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(courseDto,Course.class);

    }
    public List<CourseDto> entityToDto(List<Course> courses)
    {
        return  courses.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public List<Course> dtoToEntity(List<CourseDto> courseDtoList){

        return courseDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
