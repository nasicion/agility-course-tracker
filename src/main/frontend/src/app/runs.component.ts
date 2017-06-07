/**
 * Created by gnasi on 5/27/17.
 */
import {Component, Input, OnInit} from '@angular/core';
import { BootstrapModalModule } from 'ng2-bootstrap-modal';

import {Run} from './model/run';

import {RunService} from './service/run.service';
import {Course} from "./model/course";

@Component({
  selector: 'runs',
  templateUrl : './runs.component.html',
  providers: [RunService]
})

export class RunsComponent implements  OnInit {
  @Input() course:Course;
  @Input() runs:Run[];
  run:Run;

  constructor(private runService:RunService){

  }

  ngOnInit() : void {
    this.loadRuns(1);
  }

  addRun() : void {

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
