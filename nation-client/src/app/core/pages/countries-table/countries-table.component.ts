import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryStats } from '../../models/country-stats.model';
import { CountryStatsService } from '../../services/country/country-stats.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { TableColumnType } from '../../components/generic-table/generic-table/generic-table.component';

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

  constructor(private countryStatsService: CountryStatsService) {}

  ngOnInit(): void {
    this.countryStatsService.getMaxGdpPerCapita().subscribe((data) => {
      this.stats = data;
    });
  }
}
