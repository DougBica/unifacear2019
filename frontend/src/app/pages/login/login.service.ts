import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {  } from './model/login.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  constructor(private http : HttpClient) { }

  login(login: string, senha: string) : Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };

    return this.http.post<any>
      ("http://localhost:8080/scp/public/login",
        "login="+login+"&senha="+senha, 
        options);
  }

}
