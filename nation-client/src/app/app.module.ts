import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './core/pages/homepage/homepage.component';
import { CountriesTableComponent } from './core/pages/countries-table/countries-table.component';
import { ContinentsTableComponent } from './core/pages/continents-table/continents-table.component';
import { HttpClientModule } from '@angular/common/http';
import { MenuButtonComponent } from './core/components/menu-button/menu-button/menu-button.component';
import { CountryGridComponent } from './core/components/country-grid/country-grid/country-grid.component';
import { CountryLanguagesComponent } from './core/pages/country-languages/country-languages/country-languages.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { GenericTableComponent } from './core/components/generic-table/generic-table/generic-table.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    CountriesTableComponent,
    ContinentsTableComponent,
    MenuButtonComponent,
    CountryGridComponent,
    CountryLanguagesComponent,
    GenericTableComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
