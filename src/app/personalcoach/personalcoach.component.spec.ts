import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalcoachComponent } from './personalcoach.component';

describe('PersonalcoachComponent', () => {
  let component: PersonalcoachComponent;
  let fixture: ComponentFixture<PersonalcoachComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PersonalcoachComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PersonalcoachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
