import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Passagem } from '../model/passagem.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PassagemService {

  constructor(private http : HttpClient) { }

  salvar(passagem: Passagem) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/usuario/",passagem);
  }

}


