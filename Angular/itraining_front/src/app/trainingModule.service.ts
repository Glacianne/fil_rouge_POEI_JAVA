import { HttpClient } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";
import { controllerPaths } from "src/environment/environment";
import { ITrainingModule } from "src/model/trainingModule";

@Injectable({
  providedIn: 'root'
})
export class TrainingModuleService {
  trainingModuleList$ = new BehaviorSubject<ITrainingModule[]>([]);

  constructor(private http: HttpClient) {
    this.findAllTrainingModule().subscribe((res) => {console.log(res)})
  }

  public findAllTrainingModule(): Observable<any> {
    return this.http.get(`${controllerPaths.trainingModuleControllerPath}/trainingModule`)
  }
}
