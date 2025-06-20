import { Component, OnInit } from '@angular/core';
import { Country } from '../../models/country.model';
import { CountryService } from '../../services/country/country.service';
import { LoaderService } from '../../services/loader/loader.service';

@Component({
  selector: 'homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  countries: Country[] = [];
  title: string = 'All Countries';
  isLoading = false;

  constructor(
    private countryService: CountryService,
    private loaderService: LoaderService
  ) {}

  ngOnInit(): void {
    this.loaderService.show();
    this.countryService.getAllCountries().subscribe({
      next: (res) => {
        this.countries = res;
      },
      error: (err) => {
        console.error(err);
        this.loaderService.hide();
      },
      complete: () => {
        this.loaderService.hide();
      },
    });

    this.loaderService.loading$.subscribe((status) => {
      this.isLoading = status;
    });
  }
}
