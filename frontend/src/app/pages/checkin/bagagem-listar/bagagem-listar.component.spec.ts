import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BagagemListarComponent } from './bagagem-listar.component';

describe('BagagemListarComponent', () => {
  let component: BagagemListarComponent;
  let fixture: ComponentFixture<BagagemListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BagagemListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BagagemListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
