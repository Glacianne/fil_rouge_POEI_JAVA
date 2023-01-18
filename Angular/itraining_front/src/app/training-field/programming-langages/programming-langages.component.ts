import { Component } from '@angular/core';
import { TrainingModuleService } from 'src/app/trainingModule.service';
import { map, Observable } from 'rxjs';
import { ITrainingModule } from 'src/model/trainingModule';

@Component({
  selector: 'app-programming-langages',
  templateUrl: './programming-langages.component.html',
  styleUrls: ['./programming-langages.component.scss'],
})
export class ProgrammingLangagesComponent {
  constructor(private trainingModuleService: TrainingModuleService) {}

  trainingModuleList$: Observable<ITrainingModule[]> =
    this.trainingModuleService.trainingModuleList$.asObservable();
}
