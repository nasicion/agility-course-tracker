package com.nasicion.agility_course_tracker.dao;

import com.nasicion.agility_course_tracker.model.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnasi on 6/6/17.
 */
public interface CourseDao extends CrudRepository<Course, Long>{

}
