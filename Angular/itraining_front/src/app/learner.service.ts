import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { ILearnerAccount } from 'src/model/userAccount';

@Injectable({
  providedIn: 'root',
})
export class LearnerService {
  learnerList$ = new BehaviorSubject<ILearnerAccount[]>([]);

  constructor(private http: HttpClient) {
    this.findAllLearner().subscribe((res) => {
      this.learnerList$.next(res);
    });
  }

  public findAllLearner(): Observable<ILearnerAccount[]> {
    return this.http
      .get(`${controllerPaths.learnerControllerPath}/learner`)
      .pipe(
        map((res) => {
          const learnerList: ILearnerAccount[] = [];
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            for (const learnerElem of value) {
              const learner: ILearnerAccount = {
                ...learnerElem,
              };
              learnerList.push(learner);
            }
          }
          return learnerList;
        })
      );
  }

  public createLearner(
    firstName: string,
    lastName: String,
    email: string,
    phone: string,
    password: string
  ): Observable<any> {
    return this.http
      .post(`${controllerPaths.learnerControllerPath}/learner`, {
        firstName: firstName,
        lastName: lastName,
        email: email,
        phone: phone,
        password: password,
      })
      .pipe(
        map((res) => {
          return this.findAllLearner().subscribe((res) => {
            this.learnerList$.next(res);
          });
        })
      );
  }

  public findLearnerById(id: number): Observable<ILearnerAccount | null> {
    // return this.learnerList$
    //   .getValue()
    //   .find((learnerAccount) => learnerAccount.id === id);
    return this.http
      .get(`${controllerPaths.learnerControllerPath}/learner/${id}`)
      .pipe(
        map((res) => {
          var learner: ILearnerAccount | null = null;
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

  public updateLearner(
    id: number,
    learnerAccount: ILearnerAccount
  ): Observable<ILearnerAccount | null> {
    return this.http
      .put(
        `${controllerPaths.learnerControllerPath}/learner/${id}`,
        learnerAccount
      )
      .pipe(
        map((res) => {
          var learner: ILearnerAccount | null = null;
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

  public deleteLearner(id: number): void {
    this.http
      .delete(`${controllerPaths.learnerControllerPath}/learner/${id}`)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
