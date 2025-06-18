import { Component, Input, OnInit } from '@angular/core';
import { Country } from 'src/app/core/models/country.model';

@Component({
  selector: 'country-grid',
  templateUrl: './country-grid.component.html',
  styleUrls: ['./country-grid.component.css'],
})
export class CountryGridComponent implements OnInit {
  @Input() country!: Country;
  @Input() languageName?: string;
  constructor() {}

  ngOnInit(): void {}

  getLinkPath(countryId: number): string {
    return `/countries/${countryId}/languages`;
  }
}
