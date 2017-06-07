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
      new Run(0, 1, "dog", "guide", 0, 0, 45.5, 0, 1),
      new Run(0, 2, "dog", "guide", 0, 0, 45.5, 0, 2),
      new Run(0, 3, "dog", "guide", 0, 0, 45.5, 0, 3),
      new Run(0, 4, "dog", "guide", 0, 0, 45.5, 0, 4),
      new Run(0, 5, "dog", "guide", 0, 0, 45.5, 0, 5),
      new Run(0, 6, "dog", "guide", 0, 0, 45.5, 1, 6),
      new Run(0, 7, "dog", "guide", 0, 0, 45.5, 2, 7),
      new Run(0, 8, "dog", "guide", 0, 0, 45.5, 0, 8),
      new Run(0, 9, "dog", "guide", 0, 0, 45.5, 0, 9),
      new Run(0, 10, "dog", "guide", 0, 0, 45.5, 1, 10),
      new Run(0, 11, "dog", "guide", 0, 0, 45.5, 2, 11),
      new Run(0, 12, "dog", "guide", 0, 0, 45.5, 1, 12),
      new Run(0, 13, "dog", "guide", 0, 0, 45.5, 1, 13)
    ];

  }
}
