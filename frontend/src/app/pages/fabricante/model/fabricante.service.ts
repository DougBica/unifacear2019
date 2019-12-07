import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Fabricante } from './fabricante.model';

@Injectable({
  providedIn: 'root'
})
export class FabricanteService {
  
  
  constructor(private http : HttpClient) { }

  list() : Observable<Fabricante[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Fabricante[]>("http://localhost:8080/scp/private/fabricante/listar",options);
  }

  buscarPorId(guidFabricante: string) : Observable<Fabricante>  {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Fabricante>("http://localhost:8080/scp/private/fabricante/buscarPorId/"+guidFabricante,options);
  }

  salvar(fabricante: Fabricante) : Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.post<any>
      ("http://localhost:8080/scp/private/fabricante/salvar/",fabricante,options);
  }

  remover(fabricante: Fabricante) : Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.delete<any>
      ("http://localhost:8080/scp/private/fabricante/remover/"+fabricante.guidFabricante,options);
  }


}
