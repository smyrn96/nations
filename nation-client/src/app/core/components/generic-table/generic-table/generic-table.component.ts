import {
  Component,
  Input,
  OnInit,
  SimpleChange,
  SimpleChanges,
  ViewChild,
} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

export interface TableColumnType {
  header: string;
  field: string;
}

@Component({
  selector: 'generic-table',
  templateUrl: './generic-table.component.html',
  styleUrls: ['./generic-table.component.css'],
})
export class GenericTableComponent implements OnInit {
  @Input() columns: TableColumnType[] = [];
  @Input() data: any[] = [];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  displayedColumns: string[] = [];
  dataSource = new MatTableDataSource<any>();

  constructor() {}

  ngOnInit(): void {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['columns'] && this.columns.length > 0) {
      this.displayedColumns = this.columns.map((col) => col.field);
    }

    if (changes['data'] && this.data.length > 0) {
      this.dataSource = new MatTableDataSource(this.data);
    }
  }

  ngAfterViewInit() {
    if (this.dataSource) {
      this.dataSource.paginator = this.paginator;
    }
  }

  getValue(obj: any, path: string): any {
    return path.split('.').reduce((acc, part) => acc?.[part], obj);
  }
}
