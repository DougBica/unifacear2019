import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Remarca } from './model/remarca.model';

@Injectable({
  providedIn: 'root'
})
export class RemarcaService {

  constructor(private http: HttpClient) {
  }
  find(): Observable<Remarca[]>{
    return this.http.get<Remarca[]>("http://localhost:8080/scp/public/remarca")
  }
  save(remarca: Remarca): Observable<any>{
    return this.http.post<any>('http://localhost:8080/scp/public/remarca', remarca)
  }
}
