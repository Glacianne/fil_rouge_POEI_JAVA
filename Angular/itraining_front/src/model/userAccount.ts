export interface IUserAccount {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  password: string;
}

export interface ITeacherAccount extends IUserAccount {
  subject: string;
  experience: number;
}


export interface IAdministratorAccount extends IUserAccount {}


export interface ILearnerAccount extends IUserAccount {}
