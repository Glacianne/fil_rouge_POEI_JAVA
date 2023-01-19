export const environment = {
  springURL: 'http://localhost:8080',
};

export const controllerPaths = {
  learnerControllerPath: `${environment.springURL}/learnerController`,
  trainingModuleControllerPath: `${environment.springURL}/trainingModuleController`,
  teacherControllerPath: `${environment.springURL}/teacherController`,
  sessionControllerPath: `${environment.springURL}/sessionController`,
  administratorControllerPath: `${environment.springURL}/administratorController`,

};
