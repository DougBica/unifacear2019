import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TipoPagamento } from '../model/tipo-pagamento.model';

@Injectable({
  providedIn: 'root'
})
export class TipoPagamentoService {

  private readonly API = 'http://200.98.142.28:8080/scp/public/tipoPagamento/'

  constructor(private http : HttpClient) { }

  listById(id: String) : Observable<TipoPagamento>{
    return this.http.get<TipoPagamento>(this.API+id);
  }

  listAll(){
    return this.http.get<TipoPagamento[]>(this.API);
  }

  salvar(reserva: TipoPagamento) : Observable<any> {
    return this.http.post<any>(this.API, reserva);
  }

}

