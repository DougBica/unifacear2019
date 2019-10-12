import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Aeronave } from './model/aeronave.model';

@Injectable({
  providedIn: 'root'
})
export class AeronaveService {

  constructor(private http : HttpClient) { }

  list() : Observable<Aeronave[]> {
    return this.http.get<Aeronave[]>("http://localhost:8080/aeronave/listar");
  }

}
