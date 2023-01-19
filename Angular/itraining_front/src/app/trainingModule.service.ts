import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { ILearnerAccount } from 'src/model/userAccount';
import { ISession } from 'src/model/session';
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

  public findTrainingModuleById(
    id: number
  ): Observable<ITrainingModule | null> {
    // return this.learnerList$
    //   .getValue()
    //   .find((learnerAccount) => learnerAccount.id === id);
    return this.http
      .get(
        `${controllerPaths.trainingModuleControllerPath}/trainingModule/${id}`
      )
      .pipe(
        map((res) => {
          var learner: ITrainingModule | null = null;
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            learner = {
              ...value,
            };
          }
          return learner;
        })
      );
  }

  public createTrainingModule(
    title: string,
    startDate: Date,
    endDate: Date,
    sessionList: ISession[],
    registeredLearnerList: ILearnerAccount[]
  ): Observable<any> {
    return this.http
      .post(`${controllerPaths.trainingModuleControllerPath}/trainingModule`, {
        title: title,
        startDate: startDate,
        endDate: endDate,
        sessionList: sessionList,
        registeredLearnerList: registeredLearnerList,
      })
      .pipe(
        map((res) => {
          return this.findAllTrainingModule().subscribe((res) => {
            this.trainingModuleList$.next(res);
          });
        })
      );
  }

  public updateTrainingModule(
    id: number,
    trainingModule: ITrainingModule
  ): Observable<ITrainingModule | null> {
    return this.http
      .put(
        `${controllerPaths.trainingModuleControllerPath}/trainingModule/${id}`,
        trainingModule
      )
      .pipe(
        map((res) => {
          var trainingModule: ITrainingModule | null = null;
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            trainingModule = {
              ...value,
            };
          }
          return trainingModule;
        })
      );
  }

  public deleteTrainingModule(id: number): void {
    this.http
      .delete(
        `${controllerPaths.trainingModuleControllerPath}/trainingModule/${id}`
      )
      .subscribe((res) => {
        console.log(res);
      });
  }
}
