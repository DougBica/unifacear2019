import { ElementRef } from '@angular/core';
import { TipoPagamentoService } from './../service/tipo-pagamento.service';
import { ReservaService } from '../service/reserva.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { PassagemService } from '../service/passagem.service';
import { Passagem } from '../model/passagem.model';
import { Reserva } from '../model/reserva.model';
import { TipoPagamento } from '../model/tipo-pagamento.model';
import * as jsPDF from 'jspdf'


@Component({
  selector: 'app-carrinho-passagem',
  templateUrl: './carrinho-passagem.component.html',
  styleUrls: ['./carrinho-passagem.component.scss']
})
export class CarrinhoPassagemComponent implements OnInit {
 
  pagamentoPassagem: any = false;
  closeResult: string;
  login: boolean = false;
  passagem: Passagem = null;
  reserva: Reserva = new Reserva();
  tipoPagamento: TipoPagamento;
  viewValorReserva: number = 0;


  // Array populado com as passgens da tela de busca
  listaPassagens: Array<Passagem> = JSON.parse(localStorage.getItem("passagens"));
  // listaPassagens: Array<Passagem> = [
  //   { 
  //     guidPassagem: null,
  //     guidRota: 1,
  //     classePassagem: "CLASSE_EXECUTIVA",
  //     dataPartida: new Date(),
  //     origem: "CURITIBA",
  //     destino: "SÃO PAULO",
  //     active: true,
  //     isKid: false,
  //     valorPassagem: 250.4,
  //     nomePassageiro: "ADSas",
  //     cpfPassageiro: "",  
  //     guidReserva: null
  //    }
  // ]

  
  constructor(
    private passagemService: PassagemService, 
    private reservaService: ReservaService, 
    private tipoPagamentoService: TipoPagamentoService,
    ) { 
    
  }

  ngOnInit() { 
    // var passagens = JSON.parse(localStorage.getItem("passagens"));
    // this.listaPassagens = passagens;
    // console.log(passagens);
    this.calcularValorReserva();
  }

  listPassagemById(){ 
    this.passagemService.listById("1").subscribe(passagem => {
      console.log("Nome: "+passagem.nomePassageiro + "/ CPF: "+passagem.cpfPassageiro)
    });
  }

  listAllPassagens(){
    this.passagemService.listAll().subscribe(passagens => {
      console.log("List ALL Passagens");
      passagens.forEach(element => {
        console.log("Nome: "+element.nomePassageiro + "/ CPF: "+element.cpfPassageiro)
      });
    });
  }

  listAllReservas(){
    this.reservaService.listAll().subscribe(reservasF => {
      console.log("List ALL Reservas");
      reservasF.forEach(element => {
        console.log("Valor Reserva: "+element.valorReserva)
      });
    });
  }

  listAllTipoPagamento(){
    this.tipoPagamentoService.listAll().subscribe(tPagamento => {
      console.log("List ALL Tipo Pagamento");
      tPagamento.forEach(element => {
        console.log("Valor Reserva: "+element.descricaoPagamento);
      });
    });
  }

  calcularValorReserva(){
    this.listaPassagens.forEach(passagem => {
      this.viewValorReserva += passagem.valorPassagem;
    });
  }

  pagarReserva(login: boolean){
    localStorage.setItem("listaPassagens", JSON.stringify(this.listaPassagens));
    if (login) {
      this.pagamentoPassagem = true;
    }
  }   
  
  gerarPDF(){
    var doc = new jsPDF();
    doc.text('PASSAGENS', 90, 15);
    doc.text('------------------------------------------------------------------------------------------------------------', 4, 30);
    doc.text('NOME DO PASSAGEIRO:', 5, 40);
    doc.text('CPF:', 5, 48);
    doc.text('DATA DE PARTIDA:', 95, 48);
    doc.text('CLASSE:', 5, 56);
    doc.text('VALOR:', 95, 56);
    doc.text('ORIGEM:', 5, 64);
    doc.text('DESTINO:', 95, 64);
    doc.text('------------------------------------------------------------------------------------------------------------', 4, 72);
    doc.text('NOME DO PASSAGEIRO:', 5, 80);
    doc.text('CPF:', 5, 88);
    doc.text('DATA DE PARTIDA:', 95, 88);
    doc.text('CLASSE:', 5, 96);
    doc.text('VALOR:', 95, 96);
    doc.text('ORIGEM:', 5, 104);
    doc.text('DESTINO:', 95, 104);
    
    doc.output('save','test.pdf')
    //doc.save('two-by-four.pdf')
    //doc.addPage('a6', 'l');
    
   }
  
        
}
