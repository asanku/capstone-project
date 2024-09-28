import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AthleteprofComponent } from './athleteprof.component';

describe('AthleteprofComponent', () => {
  let component: AthleteprofComponent;
  let fixture: ComponentFixture<AthleteprofComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AthleteprofComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AthleteprofComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
