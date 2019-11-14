import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrinhoPassagemComponent } from './carrinho-passagem.component';

describe('CarrinhoPassagemComponent', () => {
  let component: CarrinhoPassagemComponent;
  let fixture: ComponentFixture<CarrinhoPassagemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarrinhoPassagemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarrinhoPassagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
