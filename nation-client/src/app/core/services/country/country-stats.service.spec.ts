import { TestBed } from '@angular/core/testing';

import { CountryStatsService } from './country-stats.service';

describe('CountryStatsService', () => {
  let service: CountryStatsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CountryStatsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
