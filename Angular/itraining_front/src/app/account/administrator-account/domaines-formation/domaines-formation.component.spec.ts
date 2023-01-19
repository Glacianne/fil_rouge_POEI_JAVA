import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DomainesFormationComponent } from './domaines-formation.component';

describe('DomainesFormationComponent', () => {
  let component: DomainesFormationComponent;
  let fixture: ComponentFixture<DomainesFormationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DomainesFormationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DomainesFormationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
