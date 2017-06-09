/**
 * Created by guillermo.nasi on 02/06/2017.
 */
import {Injectable} from '@angular/core'
import {Http, Headers} from "@angular/http";

import "rxjs/add/operator/toPromise";

import {Constants} from '../constants';

import {Run} from '../model/run'

@Injectable()
export class RunService {

  private runUrl = Constants.apiUrl + '/run';  // URL to web api
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http:Http){}

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  /**
   * \
   * @param run
   */
  save(run:Run) : void {
    console.log('Saving run:');
    console.log(run);
  }

  /**
   *
   * @param courseId
   * @returns {Run[]}
   */
  getCourseRuns(courseId:number) : Promise<any> {
    return this.http.get(this.runUrl + '/course/' + courseId)
      .toPromise()
      .then(response => {
        // console.log(response.json());
        return response.json();
      })
      .catch(this.handleError);
  }
}

export class RunsResponse {
  key : number;
  runs: Run[];
}
