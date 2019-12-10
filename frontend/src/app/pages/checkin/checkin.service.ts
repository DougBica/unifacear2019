import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Checkin } from './model/checkin.model';
import { Usuario } from '../usuario/model/usuario.model';
import { Status } from './model/status.model';
const urlApi = 'http://200.98.142.28:8080/scp/private/checkin/';
const urlApiListar = 'http://200.98.142.28:8080/scp/private/checkin/listarAberto';
const urlApiUsuario = 'http://200.98.142.28:8080/scp/private/usuario/meuId/'
const urlApiStatus = 'http://200.98.142.28:8080/scp/public/statuscheckin/'
const urlApiToken = 'http://200.98.142.28:8080/scp/private/checkin/token/';
const urlApiUsuarioPassageiro = 'http://200.98.142.28:8080/scp/private/checkin/passageiro/';

@Injectable({
  providedIn: 'root'
})
export class CheckinService {

  constructor(private http: HttpClient) { }
  
  load(): Observable<Checkin[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Checkin[]>(urlApiListar, options);
  }

  loadById(id: number): Observable<Checkin> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Checkin>(urlApi+id, options);
  }

  save(checkin: Checkin): Observable<Checkin> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.post<Checkin>(urlApi, checkin, options);
  }

  listarPorId(id: number): Observable<Usuario> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Usuario>(urlApiUsuario+id, options);
  }

  lisarPorStatus(id: number) {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Status>(urlApiStatus+id, options);
  }

  listarToken(token: string): Observable<Checkin> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Checkin>(urlApiToken+token, options);
  }

  listarPorUsuario(id: number): Observable<Checkin[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Checkin[]>(urlApiUsuarioPassageiro+id, options);
  }

}
