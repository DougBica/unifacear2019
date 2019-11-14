import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmbarqueListarComponent } from './embarque-listar.component';

describe('EmbarqueListarComponent', () => {
  let component: EmbarqueListarComponent;
  let fixture: ComponentFixture<EmbarqueListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmbarqueListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmbarqueListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
