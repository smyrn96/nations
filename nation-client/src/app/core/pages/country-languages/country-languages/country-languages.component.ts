import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Language } from 'src/app/core/models/language.model';
import { LanguageService } from 'src/app/core/services/language/language.service';
import { LoaderService } from 'src/app/core/services/loader/loader.service';

@Component({
  selector: 'country-languages',
  templateUrl: './country-languages.component.html',
  styleUrls: ['./country-languages.component.css'],
})
export class CountryLanguagesComponent implements OnInit {
  languages: Language[] = [];
  title: string = 'Languages to speak';
  isLoading = false;

  constructor(
    private route: ActivatedRoute,
    private languageService: LanguageService,
    private loaderService: LoaderService
  ) {}

  ngOnInit(): void {
    const countryId = +this.route.snapshot.paramMap.get('countryId')!;
    this.loaderService.show();
    this.languageService.getLanguagesByCountryId(countryId).subscribe({
      next: (res) => {
        this.languages = res;
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
