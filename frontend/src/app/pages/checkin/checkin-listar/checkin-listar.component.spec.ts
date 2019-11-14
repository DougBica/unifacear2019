import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckinListarComponent } from './checkin-listar.component';

describe('CheckinListarComponent', () => {
  let component: CheckinListarComponent;
  let fixture: ComponentFixture<CheckinListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckinListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckinListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
