import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammingLangagesComponent } from './programming-langages.component';

describe('ProgrammingLangagesComponent', () => {
  let component: ProgrammingLangagesComponent;
  let fixture: ComponentFixture<ProgrammingLangagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgrammingLangagesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgrammingLangagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
