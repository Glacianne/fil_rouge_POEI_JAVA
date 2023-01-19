import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationsGestionProjetComponent } from './formations-gestion-projet.component';

describe('FormationsGestionProjetComponent', () => {
  let component: FormationsGestionProjetComponent;
  let fixture: ComponentFixture<FormationsGestionProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormationsGestionProjetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormationsGestionProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
