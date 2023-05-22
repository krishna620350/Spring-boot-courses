package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

//    List<Course> list;
	@Autowired
	private CourseDao coursedao;

    public CourseServiceimpl() {
//        list = new ArrayList<>();
//
//        list.add(new Course(145, "java", "this is java course"));
//        list.add(new Course(146, "java core", "this is java core course"));
    }

    @Override
    public List<Course> getCourses() {
//        return list;
    	return coursedao.findAll();
    }

	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
//		return c
		return coursedao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		coursedao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		Course c = null;
//		for(Course courseUpdate : list) {
//			if(courseUpdate.getId() == course.getId()) {
//				courseUpdate.setTitle(course.getTitle());
//				courseUpdate.setDescription(course.getDescription());
//				c = course;
//				break;
//			}
//		}
		coursedao.save(course);
		return c;
	}

	@Override
	public void deleteCourse(long courseId) {
		Course c = null;
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//				c = course;
//				list.remove(course);
//				break;
//			}
//		}
//		return c;
		Course entity = coursedao.getOne(courseId);
		coursedao.delete(entity);
	}
}
