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

  listById(){ 
    this.passagemService.listById("1").subscribe(passagem => {
      console.log("Nome: "+passagem.nomePassageiro + "/ CPF: "+passagem.cpfPassageiro)
    });
  }

  listAll(){
    this.passagemService.listAll().subscribe(passagens => {
      console.log("List ALL");
      passagens.forEach(element => {
        console.log("Nome: "+element.nomePassageiro + "/ CPF: "+element.cpfPassageiro)
      });
    });
  }

}
