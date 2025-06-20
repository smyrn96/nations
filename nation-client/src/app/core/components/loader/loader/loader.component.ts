import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LoaderService } from 'src/app/core/services/loader/loader.service';

@Component({
  selector: 'loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css'],
})
export class LoaderComponent implements OnInit {
  constructor(private loaderService: LoaderService) {}

  isLoading: Observable<boolean> = this.loaderService.loading$;

  ngOnInit(): void {}
}
