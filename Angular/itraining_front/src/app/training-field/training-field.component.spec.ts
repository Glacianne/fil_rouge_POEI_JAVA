import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingFieldComponent } from './training-field.component';

describe('TrainingFieldComponent', () => {
  let component: TrainingFieldComponent;
  let fixture: ComponentFixture<TrainingFieldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainingFieldComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrainingFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
