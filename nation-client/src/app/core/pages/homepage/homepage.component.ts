import { Component, OnInit } from '@angular/core';
import { Country } from '../../models/country.model';
import { CountryService } from '../../services/country/country.service';

@Component({
  selector: 'homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  countries: Country[] = [];
  title: string = 'All Countries';

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.countryService.getAllCountries().subscribe((data) => {
      this.countries = data;
    });

    console.log(this.countries);
  }
}
