import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { applicationUrl } from 'src/app/constants/app.constants';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(private http: HttpClient) { }

  getAllApplications() : Observable<HttpResponse<Object>> {
    return this.http.get(applicationUrl, {observe: 'response'});
  }

  deleteApplication(id: number) : Observable<HttpResponse<Object>> {
    return this.http.delete(`${applicationUrl}/${id}`, {observe: 'response'});
  }

  saveApplication(application: any) : Observable<HttpResponse<Object>> {
    return this.http.post(applicationUrl, application, {observe: 'response'});
  }

  updateApplicationStatus(body: any) : Observable<HttpResponse<Object>> {
    return this.http.put(applicationUrl, body, {observe: 'response'});
  }
}
