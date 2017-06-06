/**
 * Created by guillermo.nasi on 02/06/2017.
 */
import {Injectable, NgModule} from '@angular/core';
import {Http, Headers} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Course} from '../model/course'


@Injectable()
export class CourseService {
  constructor(private http:Http){}

  private courseUrl = 'http://localhost:8080/api/course';  // URL to web api
  private headers = new Headers({'Content-Type': 'application/json'});

  save(course:Course) : void {
    this.http.post(this.courseUrl + '/save', course, this.headers).toPromise().then(res => res.json().data as Course);
    console.log('Saving course:');
    console.log(course);
  }
}
