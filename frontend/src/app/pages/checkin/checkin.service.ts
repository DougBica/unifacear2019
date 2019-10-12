import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Checkin } from './model/checkin.model';
const urlApi = 'http://localhost:8080/checkin';

@Injectable({
  providedIn: 'root'
})
export class CheckinService {

  constructor(private http: HttpClient) { }

  load(): Observable<Checkin[]> {
    return this.http.get<Checkin[]>(urlApi);
  }

}
