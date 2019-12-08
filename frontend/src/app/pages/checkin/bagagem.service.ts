import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bagagem } from './model/bagagem.model';
import { HttpClient } from '@angular/common/http';
const urlApi = 'http://localhost:8080/scp/public/bagagem';
const urlApi2 = 'http://localhost:8080/scp/public/bagagem/listarpcheckin/';
const urlExcluir = 'http://localhost:8080/scp/public/bagagem/';

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

  loadByGuidCheckin(id: number): Observable<Bagagem[]>{
    return this.http.get<Bagagem[]>(urlApi2+id);
  }

  save(bagagem: Bagagem): Observable<Bagagem> {
    return this.http.post<Bagagem>(urlApi, bagagem);
  }

  excluir(id: number) {
    return this.http.delete<Bagagem>(urlExcluir+id);
  }

}
