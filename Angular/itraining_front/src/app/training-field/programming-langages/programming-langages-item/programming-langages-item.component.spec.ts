import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammingLangagesItemComponent } from './programming-langages-item.component';

describe('JavaComponent', () => {
  let component: ProgrammingLangagesItemComponent;
  let fixture: ComponentFixture<ProgrammingLangagesItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgrammingLangagesItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgrammingLangagesItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
