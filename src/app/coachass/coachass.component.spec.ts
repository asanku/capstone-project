import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoachassComponent } from './coachass.component';

describe('CoachassComponent', () => {
  let component: CoachassComponent;
  let fixture: ComponentFixture<CoachassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoachassComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoachassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
