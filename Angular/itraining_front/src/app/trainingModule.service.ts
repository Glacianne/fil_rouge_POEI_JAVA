import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { ILearnerAccount } from 'src/model/learnerAccount';
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
              console.log(trainingModuleElem.startDate)
              console.log(trainingModuleElem.startDate.replace(' ', 'T'))
              console.log(trainingModuleElem.endDate)
              console.log(trainingModuleElem.endDate.substring(1))
              const trainingModule: ITrainingModule = {
                id: trainingModuleElem.id,
                title: trainingModuleElem.title,
                startDate: trainingModuleElem.startDate.substring(1),
                endDate: trainingModuleElem.endDate,
                sessionList: trainingModuleElem.sessionList,
                registeredLearnerList: trainingModuleElem.registeredLearnerList,
              };
              trainingModuleList.push(trainingModule);
            }
          }
          return trainingModuleList;
        })
      );
  }

  public findTrainingModuleById(id: number): Observable<ITrainingModule | null> {
    // return this.learnerList$
    //   .getValue()
    //   .find((learnerAccount) => learnerAccount.id === id);
    return this.http
      .get(`${controllerPaths.trainingModuleControllerPath}/trainingModule/${id}`)
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
  // public createLearner(
  //   title: string,
  //   startDate: Date,
  //   endDate: Date,
  //   sessionList: ISession[],
  //   registeredLearnerList: ILearnerAccount[]
  // ): Observable<any> {
  //   return this.http
  //     .post(`${controllerPaths.trainingModuleControllerPath}/trainingModule`, {
  //       firstName: firstName,
  //       lastName: lastName,
  //       email: email,
  //       phone: phone,
  //       password: password,
  //     })
  //     .pipe(
  //       map((res) => {
  //         return this.findAllLearner().subscribe((res) => {
  //           this.learnerList$.next(res);
  //         });
  //       })
  //     );
  // }

}
