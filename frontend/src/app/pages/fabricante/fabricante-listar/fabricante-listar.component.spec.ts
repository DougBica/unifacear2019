import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FabricanteListarComponent } from './fabricante-listar.componet';




describe('FabricanteListarComponent', () => {
  let component: FabricanteListarComponent;
  let fixture: ComponentFixture<FabricanteListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FabricanteListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FabricanteListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
