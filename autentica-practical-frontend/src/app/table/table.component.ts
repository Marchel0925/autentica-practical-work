import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Application } from '../model/application.model';
import { Technology } from '../model/technology.model';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  @Input("applications") applications: Array<Application> = [];
  @Input("showForm") showForm: boolean = false;
  @Output() actionEmitter = new EventEmitter<any>();

  toDate(value: number) : Date {
    return new Date(value);
  }

  getDescription(value: any) : string {
    return value ? value : "-";
  }

  formatTechnology(t: Technology | null) : string {
    if (t) {
      return JSON.stringify(t.toDTO(), null, 2)
    }
    return "-";
  }

  emitEvent(action: string, application: Application) {
    this.actionEmitter.emit({action: action, application: application});
  }
}
