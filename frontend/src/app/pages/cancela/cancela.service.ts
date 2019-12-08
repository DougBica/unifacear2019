import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cancela } from './model/cancela.model';
import { Passagem } from '../passagem/model/passagem.model';
const api_url = "http://localhost:8080/scp/public/cancela"
@Injectable({
  providedIn: 'root'
})
export class CancelaService {
  
  constructor(private http: HttpClient) {}

  list(): Observable<Cancela[]>{
     return this.http.get<Cancela[]>(api_url)
    }
  findByid(guidCancela: string): Observable<Cancela>{
    return this.http.get<Cancela>(api_url+guidCancela)
  }
  findByidGuidUsuario(guidUsuario: string): Observable<Cancela[]>{
    return this.http.get<Cancela[]>(api_url+"/guidusuario/"+guidUsuario)
  }
  save(cancela: Cancela): Observable<any>{
    return this.http.post<any>(api_url,cancela)
  }
  delete(guidCancela: string): Observable<any>{
    return this.http.delete<any>(api_url+guidCancela)
  }
}
