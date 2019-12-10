import { Component, OnInit, TemplateRef } from '@angular/core';
import {MatIconModule} from '@angular/material';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Passagem } from '../model/passagem.model';
import * as moment from 'moment';
import { Router } from '@angular/router';


@Component({
  selector: 'app-buscar-passagem',
  templateUrl: './buscar-passagem.component.html',
  styleUrls: ['./buscar-passagem.component.css'],
})
export class BuscarPassagemComponent implements OnInit {
  // moment = require('moment');
 
  modalRef: BsModalRef | null;
  modalRef2: BsModalRef;
  config = {
    // backdrop: true,
    ignoreBackdropClick: true,
  };

  vooDe: string;
  origem: string;
  destino: string;
  dataIda: string;
  dataVolta: string;
  passagem: Passagem;
  flag: string;

  objVoo: any = {
  
  "voo1":{"origem": "Curitiba", "destino": "São Paulo", "dataIda": "2019-12-20", "dataVolta": "2019-12-30", "duracao": "1h0m", "horario": "12:30/13:20",
          "origemVolta": "São Paulo", "destinoVolta": "Curitiba", "duracaoVolta": "1h0m", "horarioVolta": "15:30/16:20", "valor": 450.4, "classepassagem": "CLASSE_EXECUTIVA"},

  "voo2":{"origem": "Curitiba", "destino": "São Paulo", "dataIda": "2019-12-20", "dataVolta": "2019-12-30", "duracao": "1h30m", "horario": "12:30/13:50",
          "origemVolta": "São Paulo", "destinoVolta": "Curitiba", "duracaoVolta": "1h30m", "horarioVolta": "11:30/11:50", "valor": 250.4, "classepassagem": "CLASSE_ECONOMICA"},

  "voo3":{"origem": "Curitiba", "destino": "São Paulo", "dataIda": "2019-12-20", "dataVolta": "2019-12-30", "duracao": "1h0m", "horario": "09:30/10:20",
          "origemVolta": "São Paulo", "destinoVolta": "Curitiba",  "duracaoVolta": "1h0m", "horarioVolta": "17:30/18:20", "valor": 315.10, "classepassagem": "PRIMEIRA_CLASSE"},

  "voo4":{"origem": "Curitiba", "destino": "Bahia", "dataIda": "2019-12-10", "dataVolta": "2019-12-15", "duracao": "2h30m", "horario": "18:00/20:30",
          "origemVolta": "Curitiba", "destinoVolta": "Bahia",  "duracaoVolta": "2h30m", "horarioVolta": "15:00/17:30", "valor": 870.10, "classepassagem": "CLASSE_EXECUTIVA"},
  
  "voo5":{"origem": "Curitiba", "destino": "Bahia", "dataIda": "2019-12-10", "dataVolta": "2019-12-15", "duracao": "3h00m", "horario": "18:00/21:00",
          "origemVolta": "Curitiba", "destinoVolta": "Bahia",  "duracaoVolta": "2h30m", "horarioVolta": "15:00/17:30", "valor": 467.10 , "classepassagem": "CLASSE_ECONOMICA"},
   
          "voo6":{"origem": "Curitiba", "destino": "Bahia", "dataIda": "2019-12-10", "dataVolta": "2019-12-15", "duracao": "3h00m", "horario": "18:00/21:00",
          "origemVolta": "Curitiba", "destinoVolta": "Bahia",  "duracaoVolta": "2h30m", "horarioVolta": "15:00/17:30", "valor": 500.10 , "classepassagem": "CLASSE_ECONOMICA"},

          "voo7":{"origem": "Curitiba", "destino": "Bahia", "dataIda": "2019-12-10", "dataVolta": "2019-12-15", "duracao": "3h00m", "horario": "18:00/21:00",
          "origemVolta": "Curitiba", "destinoVolta": "Bahia",  "duracaoVolta": "2h30m", "horarioVolta": "15:00/17:30", "valor": 600.10 , "classepassagem": "CLASSE_ECONOMICA"},
   
    };
  
  voo: JSON;
  vooIdaVolta: Array<Object> = new Array();
  classePassagem: string;
  valor: number;

  cidades: any = [{
    nome: 'Curitiba',
  }, 
  {
    nome: 'São Paulo',
  }, 
  {
    nome: 'Nova York',
  },
  {
    nome: 'Bahia',
  }

]; 
  
  cidade = "";
  nome:any;

  cidadeObj: any = {"nome":""};

  // cidadeObj = {};

  cidadeDestino = "";
  // arraykeys = {};
  cidadeDestinoObj: any = {"nome":""};
  valorConvertIda: number;
  passagens:  Array<Passagem> = new Array();

  dataIdaFormat;
  dataVoltaFormat;
  checkBebes = false;

  index: number;

  constructor(private router: Router ,private matIcon : MatIconModule,private modalService: BsModalService) { }

  ngOnInit() {
    this.voo = <JSON>this.objVoo;
    console.log(this.voo);
  }


 buscarPassagem(template: TemplateRef<any>){

  this.dataIdaFormat =  moment(this.dataIda).format('YYYY-MM-DD');
  this.dataVoltaFormat = moment(this.dataVolta).format('YYYY-MM-DD');
  let vooOK = false;
  let busca = false;

   for(var i in this.voo){
      let voo = this.voo[i];
      
       if(moment(this.dataIdaFormat).isBetween(voo.dataIda, voo.dataVolta) && 
          moment(this.dataVoltaFormat).isBetween(voo.dataIda, voo.dataVolta)){
            if(this.cidade == voo.origem && this.cidadeDestino == voo.destino){
             
              if(this.vooDe != null){    
                if(this.classePassagem != null ){         
                  

                  if(this.classePassagem == voo.classepassagem){

                    let adultos = (document.getElementById('adultos') as HTMLSelectElement).selectedIndex;
                                                      
                    if(adultos >= 1){
                      this.vooIdaVolta.push(voo);
                      this.valor = voo.valor;
                      console.log("Valor: "+this.valor);
                      // this.arraykeys = Object.keys(this.voo);
                      vooOK = true;
                     }else{                    
                       alert("Pelo menos 1 adulto!");
                       break;
                     } 
                     console.log(voo.classepassagem);
                  }
                   
                  }else{
                    alert("Selecione a classe do voo!");
                    break;
                }
              }else{
                alert("Selecione se é somente ida ou ida e volta!");
                break;
              }
            }else{
              busca = true;
              break;
            }
        }
   }


   if(busca){
     alert("Nenhum voo encontrado!");
   }
   
   if(vooOK){
    this.modalRef = this.modalService.show(template, this.config);    
   }

 }

 exitFocus(){
  let flag: boolean = true;
  this.cidades.find((element) =>{
      element.nome == this.cidade ? flag = false : null;
  }
);
  flag == true ? this.cidade = "" : null;
}

exitData(){
 
  let valorDataDeIda = (document.getElementById('dataDeIda') as HTMLInputElement).value; 
  let valorDataDeVolta = (document.getElementById('dataDeVolta') as HTMLInputElement).value; 
 
  if(valorDataDeIda == valorDataDeVolta || valorDataDeIda > valorDataDeVolta ){
    this.dataIda = null;
    this.dataVolta = null;
  }

}

exitFocusDestino(){
  let flag: boolean = true;
  this.cidades.find((element) =>{
      element.nome == this.cidadeDestino ? flag = false : null;
  }
);

  flag == true ? this.cidadeDestino = "" : null;

  let valorOrigem = (document.getElementById('origem') as HTMLInputElement).value; 
  let valorDestino = (document.getElementById('destino') as HTMLInputElement).value;
  if(valorOrigem == valorDestino){
    this.cidade = "";
    this.cidadeDestino = "";
    alert("Origem e destino não pode ter a mesma cidade!");
  }

}

 onChange = () => {
    
  try{
    this.cidadeObj = this.cidades.find((element) => 
    element.nome==this.cidade);
    
  }catch(ExceptionInformation){
    console.log("error");
  }
    console.log(this.cidadeObj);
}

onChangeDestino(){
    
  try{
    this.cidadeDestinoObj = this.cidades.find((element) => 
    element.nome==this.cidadeDestino);
  }catch(ExceptionInformation){
    console.log("error");
  }
    console.log(this.cidadeDestinoObj);

}

comprarPassagem(template2: TemplateRef<any>, index){
  index = index + 1;
  this.index = index;

  this.criarPassagemIda();
  if(this.vooDe == 'Ida e volta'){
   if(this.checkBebes == false){
    this.modalRef2 = this.modalService.show(template2, this.config); 
    if (!this.modalRef) {
      return;
    }
    console.log('fechou');
    this.modalRef.hide();
    this.modalRef = null;
   } 
}

  localStorage.setItem("passagens", JSON.stringify(this.passagens));
  this.modalRef.hide();
  this.modalRef = null;
  this.router.navigate(['/admin/carrinho-passagem']);
  this.passagens = new Array();
}

fecharModalPrincipal(){
  this.modalRef.hide();
  this.vooIdaVolta = new Array();
}

voltarModal(template: TemplateRef<any>){
  this.modalRef2.hide();
  this.modalRef2 = null;
  this.modalRef = this.modalService.show(template, this.config); 
}

criarPassagemVolta(){

  let adultos = (document.getElementById('adultos') as HTMLSelectElement).selectedIndex; 
  let criancas = (document.getElementById('criancas') as HTMLSelectElement).selectedIndex;
  let bebes = (document.getElementById('bebes') as HTMLSelectElement).selectedIndex;


  for(let i=0; i<adultos;i++){
    this.passagem = new Passagem();
    this.passagem.guidPassagem = null;
    this.passagem.guidRota = 1;
    this.passagem.valorPassagem = this.valorConvertIda;
    console.log(this.passagem.valorPassagem+"eae bixo");
    this.passagem.dataPartida = moment(this.dataVoltaFormat).toDate();
    this.passagem.origem = this.cidadeDestino;
    this.passagem.nomePassageiro = "";
    this.passagem.cpfPassageiro = "";
    this.passagem.classePassagem = this.classePassagem;
    this.passagem.destino = this.cidade;
    this.passagem.isKid = false;
    this.passagem.active = true;
    this.passagem.guidReserva = null;
     console.log(this.passagem);
    this.passagens.push(this.passagem);
  }

  for(let i=0; i<criancas;i++){
    this.passagem = new Passagem();
    this.passagem.guidPassagem = null;
    this.passagem.guidRota = 1;
    this.passagem.valorPassagem = this.valorConvertIda;
    this.passagem.dataPartida = moment(this.dataVoltaFormat).toDate();
    this.passagem.origem = this.cidadeDestino;
    this.passagem.classePassagem = this.classePassagem;
    this.passagem.destino = this.cidade;
    this.passagem.isKid = true;
    this.passagem.nomePassageiro = "";
    this.passagem.cpfPassageiro = "";
    this.passagem.active = true;
    this.passagem.guidReserva = null;
    this.passagens.push(this.passagem);
  }

  for(let i=0; i<bebes;i++){
    this.passagem = new Passagem();
    this.passagem.guidPassagem = null;
    this.passagem.guidRota = 1;
    this.passagem.valorPassagem = this.valorConvertIda;
    this.passagem.dataPartida = moment(this.dataVoltaFormat).toDate();
    this.passagem.origem = this.cidadeDestino;
    this.passagem.classePassagem = this.classePassagem;
    this.passagem.destino = this.cidade
    this.passagem.isKid = true;
    this.passagem.nomePassageiro = "";
    this.passagem.cpfPassageiro = "";
    this.passagem.active = true;
    this.passagem.guidReserva = null;
    this.passagens.push(this.passagem);
    this.checkBebes = false;
  }

  localStorage.setItem("passagens", JSON.stringify(this.passagens));
  this.modalRef2.hide();
  this.modalRef2 = null;
  this.router.navigate(['/admin/carrinho-passagem']);
  this.passagens = new Array();

}

criarPassagemIda(){
  
  let adultos = (document.getElementById('adultos') as HTMLSelectElement).selectedIndex; 
  let criancas = (document.getElementById('criancas') as HTMLSelectElement).selectedIndex;
  let bebes = (document.getElementById('bebes') as HTMLSelectElement).selectedIndex;

  var table: HTMLTableElement = <HTMLTableElement> document.getElementById("ida");
  var valorTabela = table.rows[this.index].cells[4].innerText;
  this.valorConvertIda = +valorTabela;
  console.log("Valor ida: "+this.valorConvertIda + " ind: "+this.index);


  for(let i=0; i<adultos;i++){
    this.passagem = new Passagem();
    this.passagem.guidPassagem = null;
    this.passagem.guidRota = 1;
    this.passagem.valorPassagem = this.valorConvertIda;
    this.passagem.dataPartida = moment(this.dataIdaFormat).toDate();
    this.passagem.origem = this.cidade;
    this.passagem.classePassagem = this.classePassagem;
    this.passagem.destino = this.cidadeDestino;
    this.passagem.isKid = false;
    this.passagem.nomePassageiro = "";
    this.passagem.cpfPassageiro = "";
    this.passagem.active = true;
    this.passagem.guidReserva = null;
    console.log("ADULTO");
    this.passagens.push(this.passagem);
  }

  for(let i=0; i<criancas;i++){
    this.passagem = new Passagem();
    this.passagem.guidPassagem = null;
    this.passagem.guidRota = 1;
    this.passagem.valorPassagem = this.valorConvertIda;
    this.passagem.dataPartida = moment(this.dataIdaFormat).toDate();
    this.passagem.origem = this.cidade;
    this.passagem.classePassagem = this.classePassagem;
    this.passagem.destino = this.cidadeDestino;
    this.passagem.isKid = true;
    this.passagem.nomePassageiro = "";
    this.passagem.cpfPassageiro = "";
    this.passagem.guidReserva = null;
    this.passagem.active = true;
    this.passagens.push(this.passagem);
    console.log("CRIANCA");
  }

  if(bebes == adultos){
    for(let i=0; i<bebes;i++){
      this.passagem = new Passagem();
      this.passagem.guidPassagem = null;
      this.passagem.guidRota = 1;
      this.passagem.valorPassagem = this.valorConvertIda;
      this.passagem.dataPartida = moment(this.dataIdaFormat).toDate();
      this.passagem.origem = this.cidade;
      this.passagem.classePassagem = this.classePassagem;
      this.passagem.destino = this.cidadeDestino;
      this.passagem.isKid = true;
      this.passagem.active = true;
      this.passagem.nomePassageiro = "";
      this.passagem.cpfPassageiro = "";
      this.passagem.guidReserva = null;
      this.passagens.push(this.passagem);
      this.checkBebes = false;
      console.log("bebes");
    } 

  }else if(bebes > adultos){
    this.checkBebes = true;
    alert("1 bebê para cada adulto!");
  }

  this.index = null;
  
 
}
}