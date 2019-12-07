import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AeronaveCadastrarComponent } from './aeronave-cadastrar.component';

describe('AeronaveCadastrarComponent', () => {
  let component: AeronaveCadastrarComponent;
  let fixture: ComponentFixture<AeronaveCadastrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AeronaveCadastrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AeronaveCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
