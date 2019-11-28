import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RotaListarComponent } from './rota-listar.component';

describe('RotaListarComponent', () => {
  let component: RotaListarComponent;
  let fixture: ComponentFixture<RotaListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RotaListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RotaListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
