import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TrainingModuleService } from 'src/app/trainingModule.service';

@Component({
  selector: 'app-add-formation',
  templateUrl: './add-formation.component.html',
  styleUrls: ['./add-formation.component.scss'],
})
export class AddFormationComponent {
  constructor(
    private trainingModuleService: TrainingModuleService,
    private fb: FormBuilder, private router: Router
  ) {}

  trainingModuleForm: FormGroup = this.fb.group({
    title: ['', [Validators.required]],
    startDate: [, [Validators.required]],
    endDate: [, [Validators.required]],
  });

  confirmation: boolean = false;

  public onSubmit(): void {
    this.trainingModuleService
      .createTrainingModule(
        this.trainingModuleForm.value.title,
        this.trainingModuleForm.value.startDate,
        this.trainingModuleForm.value.endDate,
        [],
        []
      )
      .subscribe(() => {
        this.router.navigate(['/langages-programmation'])
      });
      this.confirmation = true;
  }
}
