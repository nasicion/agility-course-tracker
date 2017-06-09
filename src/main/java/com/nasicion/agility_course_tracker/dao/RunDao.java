package com.nasicion.agility_course_tracker.dao;

import com.nasicion.agility_course_tracker.model.Category;
import com.nasicion.agility_course_tracker.model.Run;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gnasi on 5/25/17.
 */
public interface RunDao extends CrudRepository<Run, Long> {


    /**
     * List all the {@link Run} for a {@link com.nasicion.agility_course_tracker.model.Course} and {@link com.nasicion.agility_course_tracker.model.Category}
     *
     * @param courseId
     * @param category
     * @return
     */
    List<Run> findRunByCourseIdAndCategory(Long courseId, Category category);
}
