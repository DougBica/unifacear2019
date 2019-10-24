import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilCadastrarComponent } from './perfil-cadastrar.component';

describe('PerfilCadastrarComponent', () => {
  let component: PerfilCadastrarComponent;
  let fixture: ComponentFixture<PerfilCadastrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilCadastrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
