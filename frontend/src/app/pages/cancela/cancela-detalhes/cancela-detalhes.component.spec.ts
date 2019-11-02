import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelaDetalhesComponent } from './cancela-detalhes.component';

describe('CancelaDetalhesComponent', () => {
  let component: CancelaDetalhesComponent;
  let fixture: ComponentFixture<CancelaDetalhesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelaDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelaDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
