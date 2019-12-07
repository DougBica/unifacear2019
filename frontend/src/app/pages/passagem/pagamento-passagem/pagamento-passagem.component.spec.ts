import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagamentoPassagemComponent } from './pagamento-passagem.component';

describe('PagamentoPassagemComponent', () => {
  let component: PagamentoPassagemComponent;
  let fixture: ComponentFixture<PagamentoPassagemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagamentoPassagemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagamentoPassagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
