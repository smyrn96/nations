import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryStats } from '../../models/country-stats.model';
import { CountryStatsService } from '../../services/country/country-stats.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { TableColumnType } from '../../components/generic-table/generic-table/generic-table.component';
import { LoaderService } from '../../services/loader/loader.service';

@Component({
  selector: 'countries-table',
  templateUrl: './countries-table.component.html',
  styleUrls: ['./countries-table.component.css'],
})
export class CountriesTableComponent implements OnInit {
  stats: CountryStats[] = [];
  columns: TableColumnType[] = [
    { header: 'Name', field: 'country.name' },
    { header: 'Code', field: 'country.countryCode3' },
    { header: 'Year', field: 'year' },
    { header: 'Population', field: 'population' },
    { header: 'GDP', field: 'gdp' },
  ];
  title: string = 'Countries with Maximum GDP per population';
  isLoading = false;

  constructor(
    private countryStatsService: CountryStatsService,
    private loaderService: LoaderService
  ) {}

  ngOnInit(): void {
    this.loaderService.show();
    this.countryStatsService.getMaxGdpPerCapita().subscribe({
      next: (res) => {
        this.stats = res;
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
