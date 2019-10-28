import { Component, OnInit } from '@angular/core';
import { PassagemService } from '../service/passagem.service';
import { Passagem } from '../model/passagem.model';
import { Reserva } from '../model/reserva.model';
import { TipoPagamento } from '../model/tipo-pagamento.model';

@Component({
  selector: 'app-carrinho-passagem',
  templateUrl: './carrinho-passagem.component.html',
  styleUrls: ['./carrinho-passagem.component.scss']
})
export class CarrinhoPassagemComponent implements OnInit {

  passagem: Passagem;
  reserva: Reserva;
  tipoPagamento: TipoPagamento;
  data: Date = new Date('1995-12-17T03:24:00');
  
  constructor(private passagemService: PassagemService) { }

  ngOnInit() {
  }

  salvarPassagem(){
    this.passagem.classePassagem = "CLASSE_EXECUTIVA";
    this.passagem.cpfPassageiro = "097.283.229.76";
    this.passagem.dataPartida = this.data;
    this.passagem.destino = "Sao paulo";
    this.passagem.guidRota = 1;
    this.passagem.nomePassageiro = "Lucas";
    this.passagem.origem = "Curitiba";

    
    this.passagemService.salvar(this.passagem);

  }

}
