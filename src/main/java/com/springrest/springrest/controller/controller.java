package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController 
public class controller {
	
	@Autowired
	private CourseService service;

	@GetMapping("/home")
	public String Home() {
		return "Welcome to Spring Rest System";
	}
	
	
	//Get the Courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.service.getCourses();
		
	}
	
	//Get Single Course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.service.getCourse(Long.parseLong(courseId)); 
	}
	
	//Add Course 
//	@PostMapping(path = "/courses", consumes = "application/json")
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.service.addCourse(course);
	}
	
	//Update Course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.service.updateCourse(course);
	}
	
	//Delete Course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.service.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
