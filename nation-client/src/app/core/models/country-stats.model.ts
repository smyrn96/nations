import { Country } from './country.model';

export interface CountryStats {
  country: Country;
  year: number;
  population: number;
  gdp: number;
}
