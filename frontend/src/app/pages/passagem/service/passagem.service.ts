import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Passagem } from '../model/passagem.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { error } from '@angular/compiler/src/util';
import { Usuario } from '../../usuario/model/usuario.model';



@Injectable({
  providedIn: 'root'
})
export class PassagemService {

  private readonly API = 'http://localhost:8080/scp/public/passagem/'
  private readonly urlPrivateApi = 'http://localhost:8080/scp/private/passagem/'
  
  constructor(private http : HttpClient) {   }
  httpOptions;
  criarOptions(){
    let token =  localStorage.getItem('token');
    return this.httpOptions = {
      
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer " + token
      })
    } 
  }

  listById(id: String) : Observable<Passagem>{
    return this.http.get<Passagem>(this.API+id);
  }

  listAll(){
    return this.http.get<Passagem[]>(this.API);
  }

  salvarReserva(passagens, usuario){
    let options = this.criarOptions();
    console.log(this.urlPrivateApi + 'reserva','{ "user":' + JSON.stringify(usuario) +
    ', "listaPassagens":' + passagens + '}', options);
    return this.http.post(this.urlPrivateApi + 'reserva','{ "user":' + JSON.stringify(usuario) +
                                                            ', "listaPassagens":' + passagens + '}', options)
      .pipe(
        retry(1)       
        )

  }

  buscaUsuarioByEmail(email):Observable<Usuario>{
    let options = this.criarOptions();
    return this.http.get<Usuario>( "http://localhost:8080/scp/private/usuario/email/" + email, options)
      .pipe(
        retry(1)       
        )
  }

  salvar(passagem: Passagem) : Observable<any> {
    return this.http.post<any>(this.API, passagem);
  }
}


