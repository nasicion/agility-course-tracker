/**
 * Created by gnasi on 5/27/17.
 */
import {Component, Input} from '@angular/core';

import {Course} from './model/course';
import {CourseService} from './service/course.service';

@Component({
  templateUrl : './course.component.html',
  providers: [CourseService]
})

export class CourseComponent {
  @Input() course:Course;

  constructor(private courseService:CourseService){
    this.course = new Course();
  }

  save() {
    this.courseService.save(this.course);
  }

  updateTimes() {
    this.course.standardCourseTime =
      Math.ceil(this.course.lenght / this.course.speed);
    this.course.maximiumCourseTime =
      Math.ceil((this.course.lenght / this.course.speed)*2);
  }
}
