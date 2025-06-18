import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Language } from '../../models/language.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LanguageService {
  private baseUrl = 'http://localhost:8080/api/country-languages'; // your backend base URL

  constructor(private http: HttpClient) {}

  getLanguagesByCountryId(countryId: number): Observable<Language[]> {
    return this.http.get<Language[]>(`${this.baseUrl}/country/${countryId}`);
  }
}
