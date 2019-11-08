import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Aeronave } from './model/aeronave.model';
import { Fabricante } from '../fabricante/model/fabricante.model';

@Injectable({
  providedIn: 'root'
})
export class AeronaveService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Aeronave[]> {
    return this.http.get<Aeronave[]>("http://localhost:8080/aeronave/listar");
  }

  buscarPorId(guidaeronave: string) : Observable<Aeronave>  {
    return this.http.get<Aeronave>("http://localhost:8080/aeronave/buscarPorId/"+guidaeronave);
  }

  salvar(aeronave: Aeronave) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/aeronave/salvar/",aeronave);
  }

  remover(aeronave: Aeronave) : Observable<any> {
    return this.http.delete<any>
      ("http://localhost:8080/aeronave/remover/"+aeronave.guidaeronave);
  }

  listarfabricante() : Observable<Fabricante[]> {
    return this.http.get<Fabricante[]>("http://localhost:8080/fabricante/listar");
  }


}
