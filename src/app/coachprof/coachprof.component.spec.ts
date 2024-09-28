import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoachprofComponent } from './coachprof.component';

describe('CoachprofComponent', () => {
  let component: CoachprofComponent;
  let fixture: ComponentFixture<CoachprofComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoachprofComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoachprofComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
