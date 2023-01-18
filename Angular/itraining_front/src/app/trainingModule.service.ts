import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { ITrainingModule } from 'src/model/trainingModule';

@Injectable({
  providedIn: 'root',
})
export class TrainingModuleService {
  trainingModuleList$ = new BehaviorSubject<ITrainingModule[]>([]);

  constructor(private http: HttpClient) {
    this.findAllTrainingModule().subscribe((res) => {
      this.trainingModuleList$.next(res);
    });
  }

  public findAllTrainingModule(): Observable<ITrainingModule[]> {
    return this.http
      .get(`${controllerPaths.trainingModuleControllerPath}/trainingModule`)
      .pipe(
        map((res) => {
          const trainingModuleList: ITrainingModule[] = [];
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            for (const trainingModuleElem of value) {
              const trainingModule: ITrainingModule = {
                ...trainingModuleElem,
              };
              trainingModuleList.push(trainingModule);
            }
          }
          return trainingModuleList;
        })
      );
  }
}
