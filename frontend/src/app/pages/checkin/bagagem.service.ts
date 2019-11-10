import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bagagem } from './model/bagagem.model';
import { HttpClient } from '@angular/common/http';
const urlApi = 'http://localhost:8080/scp/public/bagagem';
const urlApi2 = 'http://localhost:8080/scp/public/bagagem/listarpcheckin/';

@Injectable({
  providedIn: 'root'
})
export class BagagemService {

  constructor(private http: HttpClient) { }

  load() : Observable<Bagagem[]> {
    return this.http.get<Bagagem[]>(urlApi);
  }
  
  loadById(id: string): Observable<Bagagem> {
    return this.http.get<Bagagem>(urlApi+id);
  }

  loadByGuidCheckin(id: string): Observable<Bagagem[]>{
    return this.http.get<Bagagem[]>(urlApi2+id);
  }

  save(checkin: Bagagem): Observable<Bagagem> {
    return this.http.post<Bagagem>(urlApi, Bagagem);
  }

}
