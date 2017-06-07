/**
 * Created by guillermo.nasi on 02/06/2017.
 */
import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";

import "rxjs/add/operator/toPromise";

import {Constants} from "../constants";

import {Course} from "../model/course";



@Injectable()
export class CourseService {
  constructor(private http:Http){}

  private courseUrl = Constants.apiUrl + '/course';  // URL to web api
  private headers = new Headers({'Content-Type': 'application/json'});

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  /**
   * Retrieve the Course from the backend
   * @param courseId
   * @returns {Observable<Response>}
   */
  get(courseId:number) : Promise<Course> {
    return this.http
      .get(this.courseUrl + '/get/' + courseId)
      .toPromise()
      .then(response => response.json() as Course)
      .catch(this.handleError);
  }

  /**
   * Save or update a course in the backend
   * @param course
   * @returns {Promise<Promise<any>>|Promise<R>}
   */
  save(course:Course) : Promise<Course> {
    return this.http.post(
      this.courseUrl + '/save', course, this.headers
    ).toPromise()
      .then(res => {
        console.log(res.json() as Course);
        return res.json();
      })
      .catch(this.handleError);
  }
}
