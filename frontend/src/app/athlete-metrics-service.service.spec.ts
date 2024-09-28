import { TestBed } from '@angular/core/testing';

import { AthleteMetricsServiceService } from './athlete-metrics-service.service';

describe('AthleteMetricsServiceService', () => {
  let service: AthleteMetricsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AthleteMetricsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
