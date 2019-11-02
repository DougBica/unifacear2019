import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelaListarComponent } from './cancela-listar.component';

describe('CancelaListarComponent', () => {
  let component: CancelaListarComponent;
  let fixture: ComponentFixture<CancelaListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelaListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelaListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
