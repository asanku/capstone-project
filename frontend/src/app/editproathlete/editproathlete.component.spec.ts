import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditproathleteComponent } from './editproathlete.component';

describe('EditproathleteComponent', () => {
  let component: EditproathleteComponent;
  let fixture: ComponentFixture<EditproathleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditproathleteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditproathleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
