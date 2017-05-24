package com.nasicion.agility_course_tracker.test;


import com.nasicion.agility_course_tracker.dto.Run;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillermo.nasi on 24/05/2017.
 */

public class OrderTest {

    @Test
    public void orderTest() {
        List<Run> runs = new LinkedList<Run>();
        //Run elim1 =
        runs.add(new Run(new Double(25.5), 0, 3));
        //Run third =
        runs.add(new Run(new Double(30.5), 1, 0));
        //Run elim2 =
        runs.add(new Run(new Double(30.5), 0, 3));
        //Run first =
        runs.add(new Run(new Double(29.4), 0, 0));
        //Run forth =
        runs.add(new Run(new Double(25.5), 2, 0));
        //Run second =
        runs.add(new Run(new Double(30.5), 0, 0));


        Collections.sort(runs);

//        for(Run run : runs) {
//            System.out.println(run);
//        }
        Assert.assertTrue(runs.get(0).getTime().equals(new Double(29.4)));
        Assert.assertTrue(runs.get(1).getTime().equals(new Double(30.5)));
        Assert.assertTrue(runs.get(2).getTime().equals(new Double(30.5)) && runs.get(2).getFaults().equals(1));

        Assert.assertTrue(runs.get(5).eliminated() && runs.get(5).getTime().equals(new Double(30.5)));
    }
}
