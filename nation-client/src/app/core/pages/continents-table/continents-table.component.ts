import { Component, OnInit } from '@angular/core';
import { CountryStatsService } from '../../services/country/country-stats.service';
import { CountryRegionStats } from '../../models/country-stats.model';
import { TableColumnType } from '../../components/generic-table/generic-table/generic-table.component';
import { RegionService } from '../../services/region/region.service';
import { Region } from '../../models/region.model';
import { LoaderService } from '../../services/loader/loader.service';

@Component({
  selector: 'continents-table',
  templateUrl: './continents-table.component.html',
  styleUrls: ['./continents-table.component.css'],
})
export class ContinentsTableComponent implements OnInit {
  title: string = 'Continents and Regions';
  regions: Region[] = [];
  countryRegionStats: CountryRegionStats[] = [];
  columns: TableColumnType[] = [
    { header: 'Continent Name', field: 'continentName' },
    { header: 'Region Name', field: 'regionName' },
    { header: 'Country Name', field: 'countryName' },
    { header: 'Year', field: 'year' },
    { header: 'Population', field: 'population' },
    { header: 'GDP', field: 'gdp' },
  ];
  fromYear: number | null = null;
  toYear: number | null = null;
  filters!: {
    region?: string;
    from: number | undefined;
    to: number | undefined;
  };
  isLoading = false;

  constructor(
    private countryStatsService: CountryStatsService,
    private regionService: RegionService,
    private loaderService: LoaderService
  ) {}

  ngOnInit(): void {
    this.loaderService.show();
    this.countryStatsService.getStatsView({}).subscribe({
      next: (res) => {
        this.countryRegionStats = res;
        this.getAllRegions();
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

  getAllRegions() {
    this.regionService.getAllRegions().subscribe({
      next: (res) => {
        this.regions = res;
      },
      error: (err) => {
        console.error(err);
        this.loaderService.hide();
      },
      complete: () => {
        this.loaderService.hide();
      },
    });
  }

  filterByRegion(event: any) {
    const selectElement = event.target as HTMLSelectElement;
    const selectedRegion = selectElement.value;

    this.filters = { ...this.filters, region: selectedRegion };
  }

  applyYearFilter(): void {
    if (this.fromYear && this.toYear && this.fromYear > this.toYear) {
      alert('From year cannot be greater than To year.');
      return;
    }

    this.filters = {
      ...this.filters,
      from: this.fromYear ?? undefined,
      to: this.toYear ?? undefined,
    };

    this.loaderService.show();
    this.countryStatsService.getStatsView(this.filters).subscribe({
      next: (res) => {
        this.countryRegionStats = res;
      },
      error: (err) => {
        console.error(err);
        this.loaderService.hide();
      },
      complete: () => {
        this.loaderService.hide();
      },
    });
  }
}
