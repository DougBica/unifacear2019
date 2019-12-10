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
    
    return this.http.get<Perfil[]>("http://200.98.142.28:8080/scp/private/tipoperfil",options);
  }
  buscarPorID(guidTipoPerfil: string) : Observable<Perfil>  {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.get<Perfil>("http://200.98.142.28:8080/scp/private/tipoperfil/BuscarId/"+guidTipoPerfil,options);
  }

  salvar(perfil: Perfil) : Observable<any> {
    let options = {
      headers: new HttpHeaders().set('Authorization', "Bearer "+localStorage.getItem('token'))
    };
    return this.http.post<any>
      ("http://200.98.142.28:8080/scp/private/tipoperfil/",perfil,options);
  }

}
