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
          for (const learner in res) {
            const learner: ILearnerAccount = {
              ...res,
            };
            learnerList.push(res);
          }
          return learnerList;
        })
      );
  }

  public createLearner(

  ): Observable<any> {

  }
}
