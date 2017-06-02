/**
 * Created by gnasi on 5/27/17.
 */
import {Component, Input} from '@angular/core';

import {Course} from './model/course';

@Component({
    templateUrl : './course.component.html'
})

export class CourseComponent {
  @Input() course:Course;
}
