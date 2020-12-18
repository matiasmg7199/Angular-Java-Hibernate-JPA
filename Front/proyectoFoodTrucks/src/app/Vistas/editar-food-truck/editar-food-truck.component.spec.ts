import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarFoodTruckComponent } from './editar-food-truck.component';

describe('EditarFoodTruckComponent', () => {
  let component: EditarFoodTruckComponent;
  let fixture: ComponentFixture<EditarFoodTruckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarFoodTruckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarFoodTruckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
