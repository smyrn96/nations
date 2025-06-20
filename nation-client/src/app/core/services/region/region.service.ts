import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Region } from '../../models/region.model';

@Injectable({
  providedIn: 'root',
})
export class RegionService {
  private apiUrl = 'http://localhost:8080/api/regions';

  constructor(private http: HttpClient) {}

  getAllRegions(): Observable<Region[]> {
    return this.http.get<Region[]>(this.apiUrl);
  }
}
