import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Aeronave } from './model/aeronave.model';
import { Fabricante } from '../fabricante/model/fabricante.model';

@Injectable({
  providedIn: 'root'
})
export class AeronaveService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Aeronave[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Aeronave[]>("http://200.98.142.28:8080/scp/private/aeronave/listar",options);
  }

  buscarPorId(guidaeronave: string) : Observable<Aeronave>  {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Aeronave>("http://200.98.142.28:8080/scp/private/aeronave/buscarPorId/"+guidaeronave,options);
  }

  salvar(aeronave: Aeronave) : Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.post<any>
      ("http://200.98.142.28:8080/scp/private/aeronave/salvar/",aeronave,options);
  }

  remover(aeronave: Aeronave) : Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.delete<any>
      ("http://200.98.142.28:8080/scp/private/aeronave/remover/"+aeronave.guidaeronave,options);
  }

  listarfabricante() : Observable<Fabricante[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Fabricante[]>("http://200.98.142.28:8080/scp/private/aeronave/listar",options);
  }


}
