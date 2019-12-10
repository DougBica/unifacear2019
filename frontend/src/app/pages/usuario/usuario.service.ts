import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from './model/usuario.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }


  upload(data: any): Observable<any> {
    let formData = new FormData();
    formData.append('arquivo', data, data['name']);
   
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };

    return this.http.post<any>("http://200.98.142.28:8080/scp/public/arquivo", formData, options);
  }


  list(): Observable<Usuario[]> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };

    return this.http.get<Usuario[]>("http://200.98.142.28:8080/scp/private/usuario/listar", options);
  }

  buscarPorID(guidUsuario: string): Observable<Usuario> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.get<Usuario>("http://200.98.142.28:8080/scp/private/usuario/buscarPorID/" + guidUsuario, options);
  }

  salvar(usuario: Usuario): Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem('token'))
    };
    return this.http.post<any>
      ("http://200.98.142.28:8080/scp/private/usuario/", usuario, options);
  }

}
