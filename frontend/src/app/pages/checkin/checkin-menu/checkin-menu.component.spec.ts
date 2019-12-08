import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckinMenuComponent } from './checkin-menu.component';

describe('CheckinMenuComponent', () => {
  let component: CheckinMenuComponent;
  let fixture: ComponentFixture<CheckinMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckinMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckinMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
