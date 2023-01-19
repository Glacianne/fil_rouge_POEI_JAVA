import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationsLangagesProgrammationComponent } from './formations-langages-programmation.component';

describe('FormationsLangagesProgrammationComponent', () => {
  let component: FormationsLangagesProgrammationComponent;
  let fixture: ComponentFixture<FormationsLangagesProgrammationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormationsLangagesProgrammationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormationsLangagesProgrammationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
