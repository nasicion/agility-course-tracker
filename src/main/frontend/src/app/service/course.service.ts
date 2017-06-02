/**
 * Created by guillermo.nasi on 02/06/2017.
 */
import {Injectable} from '@angular/core'

import {Course} from '../model/course'

@Injectable()
export class CourseService {

  save(course:Course) : void {
    console.log('Saving course:');
    console.log(course);
  }
}
