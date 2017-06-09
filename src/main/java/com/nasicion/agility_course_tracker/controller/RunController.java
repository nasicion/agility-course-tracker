package com.nasicion.agility_course_tracker.controller;

import com.nasicion.agility_course_tracker.model.Run;
import com.nasicion.agility_course_tracker.service.CourseService;
import com.nasicion.agility_course_tracker.service.RunService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by gnasi on 5/25/17.
 */
@Controller
@RequestMapping("/api/run")
public class RunController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunController.class);

    @Autowired
    private RunService runService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Run createRun(@RequestBody Run run) {
        LOGGER.debug("Calling /api/run/add");
        runService.save(run);
        return run;
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, List<Run>> getCourseRuns(@PathVariable Long courseId) {
        LOGGER.debug("Calling /api/run/course/" + courseId);

        courseService.updateResults(courseId);
        Map<Integer, List<Run>> runs = runService.getCourseRuns(courseId);

        return runs;
    }
}
