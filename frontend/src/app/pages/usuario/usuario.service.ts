import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from './model/usuario.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  
  constructor(private http : HttpClient) { }

  list() : Observable<Usuario[]> {
    return this.http.get<Usuario[]>("http://localhost:8080/usuario");
  }

  buscarPorID(guidUsuario: string) : Observable<Usuario>  {
    return this.http.get<Usuario>("http://localhost:8080/usuario/"+guidUsuario);
  }

  salvar(usuario: Usuario) : Observable<any> {
    return this.http.post<any>
      ("http://localhost:8080/usuario/",usuario);
  }

}
