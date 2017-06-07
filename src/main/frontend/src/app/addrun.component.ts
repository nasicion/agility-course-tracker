
import {Component} from "@angular/core";
import {DialogComponent, DialogService} from "ng2-bootstrap-modal";
import {Run} from "./model/run";



@Component({
  selector : "addRun",
  templateUrl : "./addrun.component.html"
})

export class AddRunComponent extends DialogComponent<Run, boolean> {
  constructor(dialogService: DialogService) {
    super(dialogService);
  }

  confirm() {
    // we set dialog result as true on click on confirm button,
    // then we can get dialog result from caller code
    this.close();
  }
}
