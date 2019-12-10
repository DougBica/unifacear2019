import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bagagem } from './model/bagagem.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const urlApi = 'http://200.98.142.28:8080/scp/private/bagagem';
const urlApi2 = 'http://200.98.142.28:8080/scp/private/bagagem/listarpcheckin/';
const urlExcluir = 'http://200.98.142.28:8080/scp/private/bagagem/';

@Injectable({
  providedIn: 'root'
})
export class BagagemService {

  constructor(private http: HttpClient) { }

  load() : Observable<Bagagem[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Bagagem[]>(urlApi, options);
  }
  
  loadById(id: string): Observable<Bagagem> {
    return this.http.get<Bagagem>(urlApi+id);
  }

  loadByGuidCheckin(id: number): Observable<Bagagem[]>{
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Bagagem[]>(urlApi2+id, options);
  }

  save(bagagem: Bagagem): Observable<Bagagem> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.post<Bagagem>(urlApi, bagagem, options);
  }

  excluir(id: number) {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.delete<Bagagem>(urlExcluir+id, options);
  }

}
