import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Checkin } from './model/checkin.model';
const urlApi = 'http://localhost:8080/scp/public/checkin/';
const urlApiAlter = 'http://localhost:8080/scp/public/checkin/alter';


@Injectable({
  providedIn: 'root'
})
export class CheckinService {

  constructor(private http: HttpClient) { }

  load(): Observable<Checkin[]> {
    return this.http.get<Checkin[]>(urlApi);
  }

  loadById(id: string): Observable<Checkin> {
    return this.http.get<Checkin>(urlApi+id);
  }

  save(checkin: Checkin): Observable<Checkin> {
    return this.http.post<Checkin>(urlApi, checkin);
  }

}
