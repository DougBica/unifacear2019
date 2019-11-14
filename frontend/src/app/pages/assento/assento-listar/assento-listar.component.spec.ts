import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssentoListarComponent } from './assento-listar.component';

describe('AssentoListarComponent', () => {
  let component: AssentoListarComponent;
  let fixture: ComponentFixture<AssentoListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssentoListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssentoListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
