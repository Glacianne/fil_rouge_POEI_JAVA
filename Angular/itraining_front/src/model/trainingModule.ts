import { ILearnerAccount } from "./learnerAccount";
import { ISession } from "./session";

export interface ITrainingModule {
  id: number,
  intitulé: string,
  startDate: Date,
  endDate: Date,
  sessionList: ISession[],
  registeredLearnerList: ILearnerAccount[]
}
