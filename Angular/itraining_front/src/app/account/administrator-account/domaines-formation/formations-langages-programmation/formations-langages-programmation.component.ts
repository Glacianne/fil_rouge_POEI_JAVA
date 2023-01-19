import { Component } from '@angular/core';
import {TrainingModuleService} from "../../../../trainingModule.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {ITrainingModule} from "../../../../../model/trainingModule";

@Component({
  selector: 'app-formations-langages-programmation',
  templateUrl: './formations-langages-programmation.component.html',
  styleUrls: ['./formations-langages-programmation.component.scss']
})
export class FormationsLangagesProgrammationComponent {
  constructor(private route: ActivatedRoute, private trainingModuleService: TrainingModuleService) {
  }

  sub: any;
  id: number = 1;
  trainingModule$: Observable<ITrainingModule | null> = this.trainingModuleService.findTrainingModuleById(this.id);

  trainingModuleList$: Observable<ITrainingModule[]> =
    this.trainingModuleService.trainingModuleList$.asObservable();

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

