import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Language } from 'src/app/core/models/language.model';
import { LanguageService } from 'src/app/core/services/language/language.service';

@Component({
  selector: 'country-languages',
  templateUrl: './country-languages.component.html',
  styleUrls: ['./country-languages.component.css'],
})
export class CountryLanguagesComponent implements OnInit {
  languages: Language[] = [];
  title: string = 'Languages to speak';

  constructor(
    private route: ActivatedRoute,
    private languageService: LanguageService
  ) {}

  ngOnInit(): void {
    const countryId = +this.route.snapshot.paramMap.get('countryId')!;
    this.languageService.getLanguagesByCountryId(countryId).subscribe({
      next: (data) => (this.languages = data),
      error: (err) => console.error(err),
    });
  }
}
