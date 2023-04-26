import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../service/application/application.service';
import { Application } from '../model/application.model';
import { Technology } from '../model/technology.model';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  title = "Application management system";
  applications: Array<Application> = [];
  application: Application | null = null;
  technologies: Array<Technology> = [];
  showForm = false;
  loading = true;

  constructor(private applicationService: ApplicationService) {}

  ngOnInit(): void {
    try {
      this.getAllApplications();
    } catch (error) {
      console.log(error);
    } finally {
      this.loading = false;
    }
  }

  handleActionEvent(event: any) {
    const a : Application = event.application;
    console.log(a);
    const action: string = event.action;
    switch (action) {
      case "delete":
        this.applicationService.deleteApplication(a.id).subscribe((response: any) => {
          console.log(response);
          if (response.body.status === 200) {
            this.getAllApplications();
          }
        });
        break;
      case "accept":
      case "reject":
        this.applicationService.updateApplicationStatus({id: a.id, status: action}).subscribe((response: any) => {
          console.log(response);
          if (response.body.status === 200) {
            this.getAllApplications();
          }
        });
        break;
    }
  }

  handleFormEvent(a: any | null) {
    if (a) {
      this.applicationService.saveApplication(a).subscribe((response: any) => {
        if (response.body.status === 201) {
          this.getAllApplications();
          this.toggleForm();
        }
    });
    } else {
      this.toggleForm();
    }
  }

  toggleForm() {this.showForm = !this.showForm;}

  private getAllApplications() {
    this.applications = [];
    this.applicationService.getAllApplications().subscribe((response: any) => {
      if (response.status === 200 && response?.body?.data) {
        for (let a of response.body.data) {
          const tech = a?.technology;
          let technology = null;
          if (tech) {
            technology = Technology.toModel(tech);
          }
          const application: Application = Application.toModel(a, technology);

          this.applications.push(application);
        }
      }
    });
  }
}
