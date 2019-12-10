import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Assento } from './model/assento.model';



@Injectable({
  providedIn: 'root'
})
export class AssentoService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Assento[]> {
    return this.http.get<Assento[]>("http://200.98.142.28:8080/assento/listar");
  }

  buscarPorId(guidassento: string) : Observable<Assento>  {
    return this.http.get<Assento>("http://200.98.142.28:8080/assento/buscarPorId/"+guidassento);
  }

  salvar(assento: Assento) : Observable<any> {
    return this.http.post<any> 
      ("http://200.98.142.28:8080/assento/salvar/",assento);
  }


}
