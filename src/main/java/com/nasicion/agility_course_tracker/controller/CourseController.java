package com.nasicion.agility_course_tracker.controller;

import com.nasicion.agility_course_tracker.dao.CourseDao;
import com.nasicion.agility_course_tracker.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gnasi on 5/25/17.
 */
@Controller
@RequestMapping("/api/course")
public class CourseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseDao courseDao;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Course createRun(@RequestBody Course course) {
        LOGGER.debug("Called /api/course/save");
        courseDao.save(course);
        return course;
    }

    @RequestMapping(value = "/get/{courseId}", method = RequestMethod.GET)
    public @ResponseBody Course getCourse(@PathVariable Long courseId) {
        LOGGER.debug("Called /api/course/get/"+courseId);
        Course course = courseDao.findOne(courseId);
        return course;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody Iterable<Course> listCourses() {
        LOGGER.debug("Called /api/course/list");
        Iterable<Course> courses = courseDao.findAll();
        return courses;
    }
}
