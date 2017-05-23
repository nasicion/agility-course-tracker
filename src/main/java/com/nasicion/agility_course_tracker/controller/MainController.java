package com.nasicion.agility_course_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by guillermo.nasi on 23/05/2017.
 */
@Controller
public class MainController {

    @RequestMapping("/main")
    public @ResponseBody String mainController(){
        System.out.println("main controller");
        return "Agility Course Helper";
    }
}
