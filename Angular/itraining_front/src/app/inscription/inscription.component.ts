import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdministratorService } from '../administrator.service';
import { LearnerService } from '../learner.service';
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss'],
})
export class InscriptionComponent {
  formGroup: FormGroup = this.fb.group({
    firstName: ['Camélia', [Validators.required, Validators.minLength(3)]],
    lastName: ['Rio', [Validators.required, Validators.minLength(3)]],
    email: [
      'daddyisthebest@example.com',
      [Validators.email, Validators.required],
    ],
    phone: [''],
    password: ['***', [Validators.required]],
    userType: ['learner', [Validators.required]],
  });

  teacherFormSup: FormGroup = this.fb.group({
    subject: ['Java', [Validators.required]],
    experience: [
      1,
      [Validators.required, Validators.min(1), Validators.max(5)],
    ],
  });

  registered: boolean = false;

  constructor(
    private learnerService: LearnerService,
    private teacherService: TeacherService,
    private administratorService: AdministratorService,
    private fb: FormBuilder
  ) {}

  public onSubmit(): void {
    if (this.formGroup.value.userType === 'learner') {
      this.learnerService
        .createLearner(
          this.formGroup.value.firstName,
          this.formGroup.value.lastName,
          this.formGroup.value.email,
          this.formGroup.value.phone,
          this.formGroup.value.password
        )
        .subscribe(() => {
          this.registered = true;
        });
      return;
    }
    if (this.formGroup.value.userType === 'administrator') {
      this.administratorService
        .createAdministrator(
          this.formGroup.value.firstName,
          this.formGroup.value.lastName,
          this.formGroup.value.email,
          this.formGroup.value.phone,
          this.formGroup.value.password
        )
        .subscribe(() => {
          this.registered = true;
        });
      return;
    }
    if (this.formGroup.value.userType === 'teacher') {
      this.teacherService
        .createTeacher(
          this.formGroup.value.firstName,
          this.formGroup.value.lastName,
          this.formGroup.value.email,
          this.formGroup.value.phone,
          this.formGroup.value.password,
          this.teacherFormSup.value.subject,
          this.teacherFormSup.value.experience
        )
        .subscribe(() => {
          this.registered = true;
        });
      return;
    }
  }
}
