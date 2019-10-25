import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FabricanteCadastrarComponent } from './fabricante-cadastrar.component';

describe('FabricanteCadastrarComponent', () => {
  let component: FabricanteCadastrarComponent;
  let fixture: ComponentFixture<FabricanteCadastrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FabricanteCadastrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FabricanteCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
