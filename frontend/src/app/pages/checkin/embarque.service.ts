import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Embarque } from './model/embarque.model';
const urlApi = 'http://localhost:8080/scp/private/embarque/';
const urlApiAlter = 'http://localhost:8080/scp/private/embarque/alter';
const urlApiList = 'http://localhost:8080/scp/private/embarque/checkin/';

@Injectable({
  providedIn: 'root'
})
export class EmbarqueService {

  constructor(private http: HttpClient) { }

  load(): Observable<Embarque[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Embarque[]>(urlApi, options);
  }

  loadById(id: string): Observable<Embarque> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Embarque>(urlApi+id, options);
  }

  save(embarque: Embarque): Observable<Embarque> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.post<Embarque>(urlApi, embarque, options);
  }

  loadByCheckin(id: number): Observable<Embarque[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Embarque[]>(urlApiList+id, options);
  }

}
