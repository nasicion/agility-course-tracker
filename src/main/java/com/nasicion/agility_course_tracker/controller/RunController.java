package com.nasicion.agility_course_tracker.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nasicion.agility_course_tracker.dao.RunDao;
import com.nasicion.agility_course_tracker.dto.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gnasi on 5/25/17.
 */
@Controller
@RequestMapping("/api/run")
public class RunController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunController.class);

    @Autowired
    private RunDao runDao;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Run createRun(@RequestBody Run run) {
        runDao.save(run);
        LOGGER.debug(new GsonBuilder().setPrettyPrinting().create().toJson(run));
        return run;
    }
}
