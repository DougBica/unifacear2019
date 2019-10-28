import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Passagem } from '../model/passagem.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PassagemService {

  private readonly API = 'http://localhost:8080/scp/public/passagem/'

  constructor(private http : HttpClient) { }

  listById(id: String) : Observable<Passagem>{
    return this.http.get<Passagem>(this.API+id);
  }

}


