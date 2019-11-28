import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aeroporto } from './model/aeroporto.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AeroportoService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Aeroporto[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    
    return this.http.get<Aeroporto[]>("http://localhost:8080ng/scp/public/aeroporto",options);
  }

  buscarPorID(guidAeroporto: string) : Observable<Aeroporto>  {
    return this.http.get<Aeroporto>("http://localhost:8080/aeroporto/"+guidAeroporto);
  }

  salvar(aeroporto: Aeroporto) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/aeroporto/",aeroporto);
  }

}
