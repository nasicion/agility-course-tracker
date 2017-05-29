/**
 * Created by gnasi on 5/27/17.
 */
import {Component} from '@angular/core';

@Component({
    selector : 'app-root',
    templateUrl : './course.component.html'
})

export  class Course {
  judge : string
  date : Date;
  lenght : number;
  standardCourseTime : number;
  maximiumCourseTime : number;
  speed : number;
}
