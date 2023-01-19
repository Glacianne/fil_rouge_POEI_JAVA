import {Component} from '@angular/core';
import {TrainingModuleService} from 'src/app/trainingModule.service';
import {Observable} from 'rxjs';
import {ITrainingModule} from 'src/model/trainingModule';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-programming-langages',
  templateUrl: './programming-langages.component.html',
  styleUrls: ['./programming-langages.component.scss'],
})
export class ProgrammingLangagesComponent {
  constructor(private trainingModuleService: TrainingModuleService, private router: Router, private route: ActivatedRoute) {
  }

  trainingModuleList$: Observable<ITrainingModule[]> =
    this.trainingModuleService.trainingModuleList$.asObservable();

  onClickTrainingModule(trainingModuleId: number): void {
    this.router.navigate(['/programming-langages-details', String(trainingModuleId)]);
  }
}
