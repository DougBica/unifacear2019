import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cancela } from './model/cancela.model';
import { Passagem } from '../passagem/model/passagem.model';

@Injectable({
  providedIn: 'root'
})
export class CancelaService {

  constructor(private http: HttpClient) {}

  list(): Observable<Cancela[]>{
     return this.http.get<Cancela[]>("http://localhost:8080/scp/public/cancela")
    }
  findByid(guidCancela: string): Observable<Cancela>{
    return this.http.get<Cancela>("http://localhost:8080/scp/public/cancela/"+guidCancela)
  }
  findByidGuidUsuario(guidCancela: string): Observable<Cancela>{
    return this.http.get<Cancela>("http://localhost:8080/scp/public/cancela/guidUsuario/"+guidCancela)
  }
  save(cancela: Cancela): Observable<any>{
    return this.http.post<any>("http://localhost:8080/scp/public/cancela/",cancela)
  }
  delete(guidCancela: string): Observable<any>{
    return this.http.delete<any>("http://localhost:8080/scp/public/cancela/"+guidCancela)
  }
}
