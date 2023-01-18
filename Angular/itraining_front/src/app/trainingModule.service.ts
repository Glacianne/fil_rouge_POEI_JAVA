import { HttpClient } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";
import { controllerPaths } from "src/environment/environment";

@Injectable({
  providedIn: 'root'
})
export class TrainingModuleService {
  trainingModuleList$ = new BehaviorSubject<TrainingModuleService[]>([]);

  constructor(private http: HttpClient) {
  }

  public findAllTrainingModule(): Observable<any> {
    return this.http.get(`${controllerPaths.trainingModuleControllerPath}/trainingModule`)
  }
}
