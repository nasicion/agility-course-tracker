package com.nasicion.agility_course_tracker.service;

import com.nasicion.agility_course_tracker.dao.RunDao;
import com.nasicion.agility_course_tracker.model.Category;
import com.nasicion.agility_course_tracker.model.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gnasi on 6/8/17.
 */
@Service
public class RunService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunService.class);

    @Autowired
    private RunDao runDao;

    /**
     * Save or update the run
     * @param run
     */
    public void save(Run run) {
        LOGGER.debug("Called RunService.save with: " + run);
        runDao.save(run);
    }

    /**
     * Retrieve all the courses runs separated by category
     * @param courseId
     * @return
     */
    public Map<Integer, List<Run>> getCourseRuns(Long courseId) {
        HashMap<Integer, List<Run>> runs = new HashMap<Integer, List<Run>>();

        //Retrieve smalls
        List<Run> smalls = runDao.findRunByCourseIdAndCategory(courseId, Category.SMALL);
        //Retrieve medium
        List<Run> mediums = runDao.findRunByCourseIdAndCategory(courseId, Category.MEDIUM);
        //Retrieve large
        List<Run> larges = runDao.findRunByCourseIdAndCategory(courseId, Category.LARGE);

        runs.put(Category.SMALL.ordinal(), smalls);
        runs.put(Category.MEDIUM.ordinal(), mediums);
        runs.put(Category.LARGE.ordinal(), larges);

        return runs;
    }
}
