import {Resolve, ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import {CourseService} from "./service/course.service";
import {Injectable} from "@angular/core";
import {Course} from "./model/course";
/**
 * Created by gnasi on 6/9/17.
 */

@Injectable()
export class CourseResolver implements Resolve<Course> {
  constructor(private courseService:CourseService){}

  resolve(route : ActivatedRouteSnapshot, state : RouterStateSnapshot) : Promise<Course> {
    let courseId = route.params.courseId;
    let course = this.courseService.get(courseId);
    return course;
  }
}
