import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cancela } from './model/cancela.model';

@Injectable({
  providedIn: 'root'
})
export class CancelaService {

  constructor(private http: HttpClient) {}

  list(): Observable<Cancela[]>{
     return this.http.get<Cancela[]>("http://localhost:8080/scp/public/cancela")
    }
  findByid(guidCancela: number): Observable<Cancela>{
    return this.http.get<Cancela>("http://localhost:8080/scp/public/cancela" + guidCancela)
  }

}
