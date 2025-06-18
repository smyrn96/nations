import { Component } from '@angular/core';

export interface LinkType {
  title: string;
  path: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'nation-client';
  links: LinkType[] = [
    { title: 'Home', path: '/' },
    { title: 'Countries', path: '/countries-table' },
    { title: 'Continents', path: '/continents-table' },
  ];
}
