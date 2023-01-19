import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationsReseauxComponent } from './formations-reseaux.component';

describe('FormationsReseauxComponent', () => {
  let component: FormationsReseauxComponent;
  let fixture: ComponentFixture<FormationsReseauxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormationsReseauxComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormationsReseauxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
