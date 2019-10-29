import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmbarqueCadastrarComponent } from './embarque-cadastrar.component';

describe('EmbarqueCadastrarComponent', () => {
  let component: EmbarqueCadastrarComponent;
  let fixture: ComponentFixture<EmbarqueCadastrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmbarqueCadastrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmbarqueCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
