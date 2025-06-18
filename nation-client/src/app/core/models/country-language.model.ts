import { Country } from './country.model';
import { Language } from './language.model';

export interface CountryLanguage {
  country: Country;
  language: Language;
  official: boolean;
}
