/**
 * Created by gnasi on 5/27/17.
 */
import {Component, Input, OnInit} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import {Run} from './model/run';

import {RunService, RunsResponse} from './service/run.service';
import {Course} from "./model/course";

@Component({
  selector: 'runs',
  templateUrl : './runs.component.html',
  providers: [RunService]
})

export class RunsComponent implements  OnInit {
  @Input() course:Course;
  small:Run[] = [];
  medium:Run[] = [];
  large:Run[] = [];
  run:Run;
  closeResult: string;

  constructor(private runService:RunService, private modalService:NgbModal){

  }

  ngOnInit() : void {
    console.log(this.course);
    this.loadRuns(this.course.id);
  }

  addRun() : void {

  }

  loadRuns(courseId:number) {
    this.runService.getCourseRuns(courseId)
      .then(
        (resp : any) => {
          this.small = resp[1] as Run[];
          this.medium = resp[2] as Run[];
          this.large = resp[3] as Run[];
        }
      );
  }
  save() {
    this.runService.save(this.run);
  }

  updateScores() {
    console.log("Updating scores");
  }

  open(content) {
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
}
