/**
 * Created by guillermo.nasi on 02/06/2017.
 */
import {Injectable} from '@angular/core'

import {Run} from '../model/run'

@Injectable()
export class RunService {

  save(run:Run) : void {
    console.log('Saving run:');
    console.log(run);
  }

  getCourseRuns(courseId:number) : Run[] {
    return [
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5),
      new Run(0, 0, "dog", "guide", 0, 0, 45.5)
    ];

  }
}
