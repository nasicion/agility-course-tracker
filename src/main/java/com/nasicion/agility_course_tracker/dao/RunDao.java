package com.nasicion.agility_course_tracker.dao;

import com.nasicion.agility_course_tracker.dto.Run;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gnasi on 5/25/17.
 */
public interface RunDao extends CrudRepository<Run, Long>{

}
