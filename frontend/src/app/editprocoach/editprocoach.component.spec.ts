import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditprocoachComponent } from './editprocoach.component';

describe('EditprocoachComponent', () => {
  let component: EditprocoachComponent;
  let fixture: ComponentFixture<EditprocoachComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditprocoachComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditprocoachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
