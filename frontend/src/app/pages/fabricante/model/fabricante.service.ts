import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Fabricante } from './fabricante.model';

@Injectable({
  providedIn: 'root'
})
export class FabricanteService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Fabricante[]> {
    return this.http.get<Fabricante[]>("http://localhost:8080/fabricante/listar");
  }

  buscarPorId(guidFabricante: string) : Observable<Fabricante>  {
    return this.http.get<Fabricante>("http://localhost:8080/fabricante/buscarPorId/"+guidFabricante);
  }

  salvar(fabricante: Fabricante) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/fabricante/salvar/",fabricante);
  }


}
