import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cancela } from './model/cancela.model';
import { Passagem } from '../passagem/model/passagem.model';
import { Checkin } from '../checkin/model/checkin.model';
const api_url = "http://200.98.142.28:8080/scp/private/cancela"
@Injectable({
  providedIn: 'root'
})
export class CancelaService {

  constructor(private http: HttpClient) { }

  list(): Observable<Cancela[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Cancela[]>(api_url, options)
  }
  findByid(guidCancela: string): Observable<Cancela> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Cancela>(api_url + guidCancela, options)
  }
  findByidGuidUsuario(guidUsuario: string): Observable<Cancela[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Cancela[]>(api_url + "/guidusuario/" + guidUsuario, options)
  }
  save(cancela: Cancela): Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.post<any>(api_url, cancela, options)
  }
  delete(guidCancela: string): Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.delete<any>(api_url + guidCancela, options)
  }
  findCheckinByGuidPassagem(guidPassagem): Observable<Checkin> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Checkin>('http://200.98.142.28:8080/scp/private/checkin/passagem/' + guidPassagem,options)
  }
}
