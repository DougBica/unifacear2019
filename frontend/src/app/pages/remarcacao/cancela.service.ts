import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cancela } from './cancela/model/cancela.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CancelaService {

  constructor(private http: HttpClient) { }

  list(): Observable<Cancela[]>{
    return this.http.get<Cancela[]>("http://localhost:8080/scp/public/cancela")
    
  }
}
