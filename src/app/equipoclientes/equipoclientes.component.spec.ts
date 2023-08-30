import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipoclientesComponent } from './equipoclientes.component';

describe('EquipoclientesComponent', () => {
  let component: EquipoclientesComponent;
  let fixture: ComponentFixture<EquipoclientesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EquipoclientesComponent]
    });
    fixture = TestBed.createComponent(EquipoclientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
