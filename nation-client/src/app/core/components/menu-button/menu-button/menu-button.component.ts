import { Component, Input, OnInit } from '@angular/core';
import { LinkType } from 'src/app/app.component';

@Component({
  selector: 'menu-button',
  templateUrl: './menu-button.component.html',
  styleUrls: ['./menu-button.component.css'],
})
export class MenuButtonComponent implements OnInit {
  @Input() link!: LinkType;

  constructor() {}

  ngOnInit(): void {}
}
