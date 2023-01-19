import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { IAdministratorAccount } from 'src/model/userAccount';

@Injectable({
  providedIn: 'root',
})
export class AdministratorService {
  administratorList$ = new BehaviorSubject<IAdministratorAccount[]>([]);

  constructor(private http: HttpClient) {
    this.findAllAdministrator().subscribe((res) => {
      this.administratorList$.next(res);
    });
  }

  public findAllAdministrator(): Observable<IAdministratorAccount[]> {
    return this.http
      .get(`${controllerPaths.administratorControllerPath}/administrator`)
      .pipe(
        map((res) => {
          const administratorList: IAdministratorAccount[] = [];
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            for (const administratorElem of value) {
              const administrator: IAdministratorAccount = {
                ...administratorElem,
              };
              administratorList.push(administrator);
            }
          }
          return administratorList;
        })
      );
  }

  public createAdministrator(
    firstName: string,
    lastName: String,
    email: string,
    phone: string,
    password: string
  ): Observable<any> {
    return this.http
      .post(`${controllerPaths.administratorControllerPath}/administrator`, {
        firstName: firstName,
        lastName: lastName,
        email: email,
        phone: phone,
        password: password,
      })
      .pipe(
        map((res) => {
          return this.findAllAdministrator().subscribe((res) => {
            this.administratorList$.next(res);
          });
        })
      );
  }

  public findAdministratorById(id: number): Observable<IAdministratorAccount | null> {
    // return this.administratorList$
    //   .getValue()
    //   .find((administratorAccount) => administratorAccount.id === id);
    return this.http
      .get(`${controllerPaths.administratorControllerPath}/administrator/${id}`)
      .pipe(
        map((res) => {
          var administrator: IAdministratorAccount | null = null;
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            administrator = {
              ...value,
            };
          }
          return administrator;
        })
      );
  }

  public updateAdministrator(
    id: number,
    administratorAccount: IAdministratorAccount
  ): Observable<IAdministratorAccount | null> {
    return this.http
      .put(
        `${controllerPaths.administratorControllerPath}/administrator/${id}`,
        administratorAccount
      )
      .pipe(
        map((res) => {
          var administrator: IAdministratorAccount | null = null;
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            administrator = {
              ...value,
            };
          }
          return administrator;
        })
      );
  }

  public deleteAdministrator(id: number): void {
    this.http
      .delete(`${controllerPaths.administratorControllerPath}/administrator/${id}`)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
