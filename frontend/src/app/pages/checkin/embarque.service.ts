import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Embarque } from './model/embarque.model';
const urlApi = 'http://localhost:8080/scp/public/embarque/';
const urlApiAlter = 'http://localhost:8080/scp/public/embarque/alter';


@Injectable({
  providedIn: 'root'
})
export class EmbarqueService {

  constructor(private http: HttpClient) { }

  load(): Observable<Embarque[]> {
    return this.http.get<Embarque[]>(urlApi);
  }

  loadById(id: string): Observable<Embarque> {
    return this.http.get<Embarque>(urlApi+id);
  }

  save(embarque: Embarque): Observable<Embarque> {
    return this.http.post<Embarque>(urlApi, embarque);
  }

}
