import {Component, OnDestroy, OnInit} from '@angular/core';
import {ITrainingModule} from "../../../../model/trainingModule";
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
import {TrainingModuleService} from "../../../trainingModule.service";

@Component({
  selector: 'app-programming-langages-item',
  templateUrl: './programming-langages-item.component.html',
  styleUrls: ['./programming-langages-item.component.scss']
})
export class ProgrammingLangagesItemComponent implements OnInit, OnDestroy {

  constructor(private route: ActivatedRoute, private trainingModuleService: TrainingModuleService) {
  }

  sub: any;
  id: number = 1;
  trainingModule$: Observable<ITrainingModule | null> = this.trainingModuleService.findTrainingModuleById(this.id);

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.trainingModule$ = this.trainingModuleService.findTrainingModuleById(this.id);
      this.trainingModule$.subscribe((res)=> {
        console.log(typeof res.endDate);
      })
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }


}
