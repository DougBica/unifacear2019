import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckinCadastrarComponent } from './checkin-cadastrar.component';

describe('CheckinCadastrarComponent', () => {
  let component: CheckinCadastrarComponent;
  let fixture: ComponentFixture<CheckinCadastrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckinCadastrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckinCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
