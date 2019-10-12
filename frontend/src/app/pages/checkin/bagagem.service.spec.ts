import { TestBed } from '@angular/core/testing';

import { BagagemService } from './bagagem.service';

describe('BagagemService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BagagemService = TestBed.get(BagagemService);
    expect(service).toBeTruthy();
  });
});
