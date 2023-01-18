import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { ILearnerAccount } from 'src/model/learnerAccount';

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
        map((res: any) => {
          const learnerList: ILearnerAccount[] = [];
          for (const responsekey in res) {
            console.log(responsekey);
            for (const learner in res[responsekey]) {
              const learner: ILearnerAccount = {
                ...res,
              };
              learnerList.push(res);
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

  // public findLearnerById(id: number): Observable<ILearnerAccount> {
  //   // return this.learnerList$
  //   //   .getValue()
  //   //   .find((learnerAccount) => learnerAccount.id === id);
  //   return this.http
  //     .get(`${controllerPaths.learnerControllerPath}/learner/${id}`)
  //     .pipe(
  //       map((res) => {
  //         const learner: ILearnerAccount = {
  //           ...res[0],
  //         };
  //       })
  //     );
  // }
}
