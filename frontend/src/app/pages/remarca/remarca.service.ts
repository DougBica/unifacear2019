import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Remarca } from './model/remarca.model';
import { Checkin } from '../checkin/model/checkin.model';

@Injectable({
  providedIn: 'root'
})
export class RemarcaService {

  constructor(private http: HttpClient) {
  }
  find(): Observable<Remarca[]> {
    return this.http.get<Remarca[]>("http://localhost:8080/scp/public/remarca")
  }
  save(remarca: Remarca): Observable<any> {
    return this.http.post<any>('http://localhost:8080/scp/public/remarca', remarca)
  }/*
  findCheckinByPassagem(id): Observable<Checkin[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Checkin[]>("http://localhost:8080/scp/private/checkin/passagem/" + id)
  }*/
}
