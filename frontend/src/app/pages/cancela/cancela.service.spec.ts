import { TestBed } from '@angular/core/testing';

import { CancelaService } from './cancela.service';

describe('CancelaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CancelaService = TestBed.get(CancelaService);
    expect(service).toBeTruthy();
  });
});
