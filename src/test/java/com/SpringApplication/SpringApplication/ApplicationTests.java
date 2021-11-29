package com.SpringApplication.SpringApplication;

import com.SpringApplication.SpringApplication.dao.CourseRepository;
import com.SpringApplication.SpringApplication.entity.Course;
import com.SpringApplication.SpringApplication.service.CourseService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;


@SpringBootTest
class ApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private CourseService courseService;

	@MockBean
	private CourseRepository courseRepository;

	@Test
	void findAllCoursesTest() {
		List<Course> tempList=new ArrayList<>();

		tempList.add(new Course("AI-ML"));
		tempList.add(new Course("Spring Boot"));

		Mockito.when(courseRepository.findAll()).thenReturn(tempList);

		assertEquals(2,courseService.findAllCourses().size());
		verify(courseRepository, times(1)).findAll();
	}

	@Test
	void findCourseById() {
		int id=1;
		Course course=new Course(1,"AI-ML");
		Optional<Course> optionalCourse=Optional.ofNullable(course);
		Mockito.when(courseRepository.findById(id)).thenReturn(optionalCourse);

		MatcherAssert.assertThat(courseService.findCourseById(id),is(course));
	}


	@Test
	void saveCourse() {
		Course course=new Course(1,"AI-ML");

	//	Mockito.when(courseRepository.save(course)).thenReturn(course);

	//	Assert.assertEquals(course,courseService.saveCourse(course));
		courseService.saveCourse(course);
		verify(courseRepository,times(1)).save(course);
	}


	@Test
	void deleteCourseById() {
		int id=1;
		Course course=new Course(1,"AI-ML");
		courseService.deleteCourseById(id);
		verify(courseRepository,times(1)).deleteById(id);
	}

}
