import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelaLIstarComponent } from './cancela-listar.component';

describe('CancelaLIstarComponent', () => {
  let component: CancelaLIstarComponent;
  let fixture: ComponentFixture<CancelaLIstarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelaLIstarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelaLIstarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
