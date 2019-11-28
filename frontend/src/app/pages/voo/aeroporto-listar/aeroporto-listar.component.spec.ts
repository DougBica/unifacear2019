import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AeroportoListarComponent } from './aeroporto-listar.component';

describe('AeroportoListarComponent', () => {
  let component: AeroportoListarComponent;
  let fixture: ComponentFixture<AeroportoListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AeroportoListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AeroportoListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
