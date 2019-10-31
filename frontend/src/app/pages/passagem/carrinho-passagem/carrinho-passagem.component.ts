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

  passagem: Passagem = null;
  reserva: Reserva = new Reserva();
  tipoPagamento: TipoPagamento;
  viewValorReserva: number = 0;


  // Este array será populado com o array que virá da tela buscar-passagem
  listaPassagens: Array<Passagem> = [
    { 
      guidPassagem: 1,
      guidRota: 1,
      classePassagem: "CLASSE_EXECUTIVA",
      dataPartida: new Date(),
      origem: "CURITIBA",
      destino: "SÃO PAULO",
      active: true,
      valorPassagem: 250.4,
      nomePassageiro: "ADSas",
      cpfPassageiro: "89",  
      reserva: new Reserva()
    },
    { 
      guidPassagem: 2,
      guidRota: 1,
      classePassagem: "CLASSE_EXECUTIVA",
      dataPartida: new Date(),
      origem: "RIO DE JANEIRO",
      destino: "MACEIÓ",
      active: true,
      valorPassagem: 232.4,
      nomePassageiro: "ADSas",
      cpfPassageiro: "89",  
      reserva: new Reserva()
    },
    { 
      guidPassagem: 3,
      guidRota: 1,
      classePassagem: "CLASSE_EXECUTIVA",
      dataPartida: new Date(),
      origem: "CURITIBA",
      destino: "BRASILIA",
      active: true,
      valorPassagem: 334.67,
      nomePassageiro: "ADSas",
      cpfPassageiro: "89",  
      reserva: new Reserva()
    },
    { 
      guidPassagem: 4,
      guidRota: 1,
      classePassagem: "CLASSE_EXECUTIVA",
      dataPartida: new Date(),
      origem: "SÃO PAULO",
      destino: "TOLEDO",
      active: true,
      valorPassagem: 564.67,
      nomePassageiro: "ADSas",
      cpfPassageiro: "89",  
      reserva: new Reserva()
    },
    { 
      guidPassagem: 5,
      guidRota: 1,
      classePassagem: "CLASSE_EXECUTIVA",
      dataPartida: new Date(),
      origem: "TOLEDO",
      destino: "BAHIA",
      active: true,
      valorPassagem: 334.67,
      nomePassageiro: "ADSas",
      cpfPassageiro: "89",  
      reserva: new Reserva()
    },
    { 
      guidPassagem: 6,
      guidRota: 1,
      classePassagem: "CLASSE_EXECUTIVA",
      dataPartida: new Date(),
      origem: "BAHIA",
      destino: "SÃO PAULO",
      active: true,
      valorPassagem: 334.67,
      nomePassageiro: "ADSas",
      cpfPassageiro: "89",  
      reserva: new Reserva()
    }
  ]

  
  constructor(private passagemService: PassagemService) { 
    this.calcularValorReserva();
  }

  ngOnInit() { 
  }

  listPassagemById(){ 
    this.passagemService.listById("1").subscribe(passagem => {
      console.log("Nome: "+passagem.nomePassageiro + "/ CPF: "+passagem.cpfPassageiro)
    });
  }

  listAllPassagens(){
    this.passagemService.listAll().subscribe(passagens => {
      console.log("List ALL");
      passagens.forEach(element => {
        console.log("Nome: "+element.nomePassageiro + "/ CPF: "+element.cpfPassageiro)
      });
    });
  }

  calcularValorReserva(){
    this.listaPassagens.forEach(passagem => {
      this.viewValorReserva += passagem.valorPassagem;
    });
  }

}
