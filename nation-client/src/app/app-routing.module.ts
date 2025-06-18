import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './core/pages/homepage/homepage.component';
import { CountriesTableComponent } from './core/pages/countries-table/countries-table.component';
import { ContinentsTableComponent } from './core/pages/continents-table/continents-table.component';
import { CountryLanguagesComponent } from './core/pages/country-languages/country-languages/country-languages.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'countries-table', component: CountriesTableComponent },
  { path: 'continents-table', component: ContinentsTableComponent },
  {
    path: 'countries/:countryId/languages',
    component: CountryLanguagesComponent,
  },
  { path: '**', redirectTo: '' }, // wildcard fallback
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
