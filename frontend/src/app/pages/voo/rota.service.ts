import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rota } from './model/rota.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RotaService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Rota[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    
    return this.http.get<Rota[]>("http://localhost:8080/scp/public/rota",options);
  }

  buscarPorID(guidRota: string) : Observable<Rota>  {
    return this.http.get<Rota>("http://localhost:8080/rota/"+guidRota);
  }

  salvar(rota: Rota) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/rota/",rota);
  }

}
