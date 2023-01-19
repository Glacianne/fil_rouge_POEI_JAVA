import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { ISession } from 'src/model/session';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  sessionList$ = new BehaviorSubject<ISession[]>([]);

  constructor(private http: HttpClient) {
    this.findAllSession().subscribe((res) => {
      this.sessionList$.next(res);
    });
  }

  public findAllSession(): Observable<ISession[]> {
    return this.http
      .get(`${controllerPaths.sessionControllerPath}/session`)
      .pipe(
        map((res) => {
          const sessionList: ISession[] = [];
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            for (const sessionElem of value) {
              const session: ISession = {
                ...sessionElem,
              };
              sessionList.push(session);
            }
          }
          return sessionList;
        })
      );
  }

  public findSessionById(id: number): Observable<ISession | null> {
    // return this.learnerList$
    //   .getValue()
    //   .find((learnerAccount) => learnerAccount.id === id);
    return this.http
      .get(`${controllerPaths.sessionControllerPath}/session/${id}`)
      .pipe(
        map((res) => {
          var learner: ISession | null = null;
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

  public createSession(
    startDate: Date,
    endDate: Date,
    room: string,
    status: boolean
  ): Observable<any> {
    return this.http
      .post(`${controllerPaths.sessionControllerPath}/session`, {
        startDate: startDate,
        endDate: endDate,
        room: room,
        status: status,
      })
      .pipe(
        map((res) => {
          return this.findAllSession().subscribe((res) => {
            this.sessionList$.next(res);
          });
        })
      );
  }

  public updateSession(
    id: number,
    session: ISession
  ): Observable<ISession | null> {
    return this.http
      .put(`${controllerPaths.sessionControllerPath}/session/${id}`, session)
      .pipe(
        map((res) => {
          var session: ISession | null = null;
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            session = {
              ...value,
            };
          }
          return session;
        })
      );
  }

  public deleteSession(id: number): void {
    this.http
      .delete(`${controllerPaths.sessionControllerPath}/session/${id}`)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
