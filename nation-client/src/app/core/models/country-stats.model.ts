import { Country } from './country.model';

export interface CountryStats {
  country: Country;
  year: number;
  population: number;
  gdp: number;
}

export interface CountryRegionStats {
  continentName: string;
  regionName: string;
  countryName: string;
  year: number;
  population: number;
  gdp: number;
}
