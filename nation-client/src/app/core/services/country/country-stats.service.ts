import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {
  CountryRegionStats,
  CountryStats,
} from '../../models/country-stats.model';

@Injectable({
  providedIn: 'root',
})
export class CountryStatsService {
  private baseUrl = 'http://localhost:8080/api/country-stats';

  constructor(private http: HttpClient) {}

  getMaxGdpPerCapita(): Observable<CountryStats[]> {
    return this.http.get<CountryStats[]>(`${this.baseUrl}/max-gdp-per-capita`);
  }

  getStatsView(filters: {
    region?: string;
    from?: number;
    to?: number;
  }): Observable<CountryRegionStats[]> {
    let params = new HttpParams();
    if (filters.region) params = params.set('region', filters.region);
    if (filters.from) params = params.set('from', filters.from.toString());
    if (filters.to) params = params.set('to', filters.to.toString());

    return this.http.get<CountryRegionStats[]>(`${this.baseUrl}/region-stats`, {
      params,
    });
  }
}
