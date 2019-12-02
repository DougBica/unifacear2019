import { TipoPagamentoService } from './../service/tipo-pagamento.service';
import { ReservaService } from '../service/reserva.service';
import { Component, OnInit } from '@angular/core';
import { PassagemService } from '../service/passagem.service';
import { Passagem } from '../model/passagem.model';
import { Reserva } from '../model/reserva.model';
import { TipoPagamento } from '../model/tipo-pagamento.model';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { ModalLoginComponent } from '../modalLogin/modal-login.component';

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
      isKid: false,
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
      isKid: false,
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
      isKid: false,
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
      isKid: false,
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
      isKid: false,
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
      isKid: false,
      valorPassagem: 334.67,
      nomePassageiro: "ADSas",
      cpfPassageiro: "89",  
      reserva: new Reserva()
    }
  ]

  
  constructor(
    private passagemService: PassagemService, 
    private reservaService: ReservaService, 
    private tipoPagamentoService: TipoPagamentoService,
    ) { 
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

  salvarReserva(){
    this.reserva.active = true;
    this.reserva.guidUsuario = 1;
    this.reserva.paid = false;
    this.reserva.valorReserva = this.viewValorReserva;
    this.reservaService.salvar(this.reserva);

    this.listAllPassagens();
    this.listAllReservas(); 
    this.listAllTipoPagamento();

    console.log('Executado salvarReserva()');
  }

  pagarReserva(login: boolean){
    localStorage.setItem("listaPassagens", JSON.stringify(this.listaPassagens));
    if (login) {
      this.pagamentoPassagem = true;
    }
  }       
        
}
