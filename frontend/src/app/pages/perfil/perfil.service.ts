import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Perfil } from './model/perfil.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Perfil[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    
    return this.http.get<Perfil[]>("http://localhost:8080/scp/private/usuario",options);
  }

  buscarPorID(guidUsuario: string) : Observable<Perfil>  {
    return this.http.get<Perfil>("http://localhost:8080/usuario/buscarPorID/"+guidUsuario);
  }

  salvar(usuario: Perfil) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/usuario/salvar/",usuario);
  }

}
