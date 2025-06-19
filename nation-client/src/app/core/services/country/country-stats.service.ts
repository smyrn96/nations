import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CountryStats } from '../../models/country-stats.model';

@Injectable({
  providedIn: 'root',
})
export class CountryStatsService {
  private baseUrl = 'http://localhost:8080/api/country-stats';

  constructor(private http: HttpClient) {}

  getMaxGdpPerCapita(): Observable<CountryStats[]> {
    return this.http.get<CountryStats[]>(`${this.baseUrl}/max-gdp-per-capita`);
  }
}
