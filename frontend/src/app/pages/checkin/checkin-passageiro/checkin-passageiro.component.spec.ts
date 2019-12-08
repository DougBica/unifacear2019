import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckinPassageiroComponent } from './checkin-passageiro.component';

describe('CheckinPassageiroComponent', () => {
  let component: CheckinPassageiroComponent;
  let fixture: ComponentFixture<CheckinPassageiroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckinPassageiroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckinPassageiroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
