import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssentoCadastrarComponent } from './assento-cadastrar.component';

describe('AssentoCadastrarComponent', () => {
  let component: AssentoCadastrarComponent;
  let fixture: ComponentFixture<AssentoCadastrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssentoCadastrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssentoCadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
