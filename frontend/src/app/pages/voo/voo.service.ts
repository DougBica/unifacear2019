import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Voo } from './model/voo.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VooService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Voo[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    
    return this.http.get<Voo[]>("http://localhost:8080/scp/public/voo",options);
  }

  buscarPorID(guidVoo: string) : Observable<Voo>  {
    return this.http.get<Voo>("http://localhost:8080/voo/"+guidVoo);
  }

  salvar(voo: Voo) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/voo/",voo);
  }

}
