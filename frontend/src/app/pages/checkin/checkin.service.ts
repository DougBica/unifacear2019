import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Checkin } from './model/checkin.model';
import { Usuario } from '../usuario/model/usuario.model';
import { Status } from './model/status.model';
const urlApi = 'http://localhost:8080/scp/public/checkin/';
const urlApiListar = 'http://localhost:8080/scp/public/checkin/listarAberto';
const urlApiAlter = 'http://localhost:8080/scp/public/checkin/alter';
const urlApiUsuario = 'http://localhost:8080/scp/public/usuario/meuId/'
const urlApiStatus = 'http://localhost:8080/scp/public/statuscheckin/'
const urlApiToken = 'http://localhost:8080/scp/public/checkin/token/';

@Injectable({
  providedIn: 'root'
})
export class CheckinService {

  constructor(private http: HttpClient) { }

  load(): Observable<Checkin[]> {
    return this.http.get<Checkin[]>(urlApiListar);
  }

  loadById(id: number): Observable<Checkin> {
    return this.http.get<Checkin>(urlApi+id);
  }

  save(checkin: Checkin): Observable<Checkin> {
    return this.http.post<Checkin>(urlApi, checkin);
  }

  listarPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(urlApiUsuario+id);
  }

  lisarPorStatus(id: number) {
    return this.http.get<Status>(urlApiStatus+id);
  }

  listarToken(token: string): Observable<Checkin> {
    return this.http.get<Checkin>(urlApiToken+token);
  }

}
