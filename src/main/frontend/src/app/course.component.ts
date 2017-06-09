/**
 * Created by gnasi on 5/27/17.
 */
import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

import { Course } from './model/course';
import { CourseService } from './service/course.service';

@Component({
  templateUrl : './course.component.html',
  providers: [CourseService]
})

export class CourseComponent implements OnInit {
  @Input() course:Course;

  constructor(private courseService:CourseService, private route:ActivatedRoute){
    let courseId = this.route.snapshot.params['courseId'];
    if(courseId != undefined) {
       this.loadCourse(courseId);
     } else {
     this.course = new Course();
     }
  }

  ngOnInit() {
    this.course = this.route.snapshot.data['course'];
    if(this.course == undefined) {
      this.course = new Course();
    }
  }

  loadCourse(courseId:number) : Promise<Course> {
    return this.courseService.get(courseId)
      .then((course : Course) => this.course = course);
  }

  save() : void {
    this.courseService.save(this.course)
      .then(
        (course: Course) =>
          this.course = course
      );
  }

  updateTimes() {
    this.course.standardCourseTime =
      Math.ceil(this.course.lenght / this.course.speed);
    this.course.maximiumCourseTime =
      Math.ceil((this.course.lenght / this.course.speed)*2);
  }
}
