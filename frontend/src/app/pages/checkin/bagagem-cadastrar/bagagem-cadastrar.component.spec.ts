import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BagagemCadastrarComponent } from './bagagem-cadastrar.component';

describe('BagagemCadastrarComponent', () => {
  let component: BagagemCadastrarComponent;
  let fixture: ComponentFixture<BagagemCadastrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BagagemCadastrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BagagemCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
