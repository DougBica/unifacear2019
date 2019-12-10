import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckinInformacoesComponent } from './checkin-informacoes.component';

describe('CheckinInformacoesComponent', () => {
  let component: CheckinInformacoesComponent;
  let fixture: ComponentFixture<CheckinInformacoesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckinInformacoesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckinInformacoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
