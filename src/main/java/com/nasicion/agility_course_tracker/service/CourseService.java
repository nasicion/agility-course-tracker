package com.nasicion.agility_course_tracker.service;

import com.nasicion.agility_course_tracker.dao.RunDao;
import com.nasicion.agility_course_tracker.model.Category;
import com.nasicion.agility_course_tracker.model.Run;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by gnasi on 6/8/17.
 */
public class CourseService {

    @Autowired
    private RunDao runDao;

    /**
     * Update the course positions and qualifications
     * @param courseId
     */
    public void updateResults(Long courseId) {
        for(Category cat : Category.values()) {
            List<Run> runs = runDao.findRunByCourseIdAndCategory(courseId, cat);
            Collections.sort(runs);
            int pos = 1;
            for(Run run : runs) {
                if(!run.eliminated() && run.getTime() != null) {
                    run.setPosition(pos);
                }
                runDao.save(run);
            }
        }

    }
}
