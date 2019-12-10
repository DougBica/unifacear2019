import { ElementRef } from '@angular/core';
import { TipoPagamentoService } from './../service/tipo-pagamento.service';
import { ReservaService } from '../service/reserva.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { PassagemService } from '../service/passagem.service';
import { Passagem } from '../model/passagem.model';
import { Reserva } from '../model/reserva.model';
import { TipoPagamento } from '../model/tipo-pagamento.model';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import * as jsPDF from 'jspdf'
import * as moment from 'moment';


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

  
        
}
