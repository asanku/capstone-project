import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AthleteassComponent } from './athleteass.component';

describe('AthleteassComponent', () => {
  let component: AthleteassComponent;
  let fixture: ComponentFixture<AthleteassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AthleteassComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AthleteassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
