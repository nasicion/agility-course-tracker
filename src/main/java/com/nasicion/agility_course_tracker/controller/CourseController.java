package com.nasicion.agility_course_tracker.controller;

import com.google.gson.GsonBuilder;
import com.nasicion.agility_course_tracker.dao.CourseDao;
import com.nasicion.agility_course_tracker.dto.Course;
import com.nasicion.agility_course_tracker.dto.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        courseDao.save(course);
        LOGGER.debug(new GsonBuilder().setPrettyPrinting().create().toJson(course));
        return course;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody Iterable<Course> listCourses() {
        Iterable<Course> courses = courseDao.findAll();
        return courses;
    }
}
