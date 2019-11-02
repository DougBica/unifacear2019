import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../usuario/model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  constructor(private http : HttpClient) {}

  salvar(usuario: Usuario) : Observable<any> {
    console.log(usuario);
    return this.http.post<any>
      ("http://localhost:8080/scp/public/register/",usuario);

  }

}
