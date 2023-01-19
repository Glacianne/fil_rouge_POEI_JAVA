import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { controllerPaths } from 'src/environment/environment';
import { ITeacherAccount } from 'src/model/userAccount';

@Injectable({
  providedIn: 'root',
})
export class TeacherService {
  teacherList$ = new BehaviorSubject<ITeacherAccount[]>([]);

  constructor(private http: HttpClient) {
    this.findAllTeacher().subscribe((res) => {
      this.teacherList$.next(res);
    });
  }

  public findAllTeacher(): Observable<ITeacherAccount[]> {
    return this.http
      .get(`${controllerPaths.teacherControllerPath}/teacher`)
      .pipe(
        map((res) => {
          const teacherList: ITeacherAccount[] = [];
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            for (const teacherElem of value) {
              const teacher: ITeacherAccount = {
                ...teacherElem,
              };
              teacherList.push(teacher);
            }
          }
          return teacherList;
        })
      );
  }

  public createTeacher(
    firstName: string,
    lastName: String,
    email: string,
    phone: string,
    password: string,
    subject: string,
    experience: number
  ): Observable<any> {
    return this.http
      .post(`${controllerPaths.teacherControllerPath}/teacher`, {
        firstName: firstName,
        lastName: lastName,
        email: email,
        phone: phone,
        password: password,
        subject: subject,
        experience: experience,
      })
      .pipe(
        map((res) => {
          return this.findAllTeacher().subscribe((res) => {
            this.teacherList$.next(res);
          });
        })
      );
  }

  public findTeacherById(id: number): Observable<ITeacherAccount | null> {
    // return this.teacherList$
    //   .getValue()
    //   .find((teacherAccount) => teacherAccount.id === id);
    return this.http
      .get(`${controllerPaths.teacherControllerPath}/teacher/${id}`)
      .pipe(
        map((res) => {
          var teacher: ITeacherAccount | null = null;
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            teacher = {
              ...value,
            };
          }
          return teacher;
        })
      );
  }

  public updateTeacher(
    id: number,
    teacherAccount: ITeacherAccount
  ): Observable<ITeacherAccount | null> {
    return this.http
      .put(
        `${controllerPaths.teacherControllerPath}/teacher/${id}`,
        teacherAccount
      )
      .pipe(
        map((res) => {
          var teacher: ITeacherAccount | null = null;
          for (const [message, value] of Object.entries(res)) {
            console.log(message);
            teacher = {
              ...value,
            };
          }
          return teacher;
        })
      );
  }

  public deleteTeacher(id: number): void {
    this.http
      .delete(`${controllerPaths.teacherControllerPath}/teacher/${id}`)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
