import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VooListarComponent } from './voo-listar.component';

describe('VooListarComponent', () => {
  let component: VooListarComponent;
  let fixture: ComponentFixture<VooListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VooListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VooListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
