/**
 * Created by gnasi on 5/27/17.
 */
import {Component, Input} from '@angular/core';

import {Run} from './model/run';

import {RunService} from './service/run.service';

@Component({
  selector: 'runs',
  templateUrl : './runs.component.html',
  providers: [RunService]
})

export class RunsComponent {
  @Input() runs:Run[];
  run:Run;

  constructor(private runService:RunService){

  }

  loadRuns(courseId:number) {
    this.runs = this.runService.getCourseRuns(courseId);
  }
  save() {
    this.runService.save(this.run);
  }

  updateScores() {
    console.log("Updating scores");
  }
}
