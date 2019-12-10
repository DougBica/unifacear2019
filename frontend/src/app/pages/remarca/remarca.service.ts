import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Remarca } from './model/remarca.model';
import { Checkin } from '../checkin/model/checkin.model';
const api_url = "http://200.98.142.28:8080/scp/private/remarca"
@Injectable({
  providedIn: 'root'
})
export class RemarcaService {

  constructor(private http: HttpClient) {
  }
  find(): Observable<Remarca[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Remarca[]>(api_url, options)
  }
  save(remarca: Remarca): Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.post<any>(api_url, remarca, options)
  }/*
  findCheckinByPassagem(id): Observable<Checkin[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Checkin[]>("http://localhost:8080/scp/private/checkin/passagem/" + id)
  }*/
}
