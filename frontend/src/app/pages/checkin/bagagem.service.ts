import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bagagem } from './model/bagagem.model';
import { HttpClient } from '@angular/common/http';
const urlApi = 'http://localhost:8080/scp/public/bagagem';

@Injectable({
  providedIn: 'root'
})
export class BagagemService {

  constructor(private http: HttpClient) { }

  load() : Observable<Bagagem[]> {
    return this.http.get<Bagagem[]>(urlApi);
  }
}
