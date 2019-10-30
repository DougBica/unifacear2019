import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-pagamento-passagem',
  templateUrl: './pagamento-passagem.component.html',
  styleUrls: ['./pagamento-passagem.component.scss']
})
export class PagamentoPassagemComponent implements OnInit {

  anoAtual : any = new Date().getUTCFullYear();
  listaAno : any = [];
  listaMes : Number [] = [1,2,3,4,5,6,7,8,9,10,11,12];
  listaCartoes: String [] = ["Visa", "Master Card", "American Express", "Elo"]

  constructor() {}
    myControl = new FormGroup ({
      bandeiraCartao: new FormControl(''),
      anoValidade: new FormControl(''),
      mesValidade: new FormControl(''),
      numeroCartao: new FormControl(''),
      codigoCartao: new FormControl(''),
      nome: new FormControl(''),
      cpf: new FormControl('')
    });
  
  ngOnInit() {
    for (let i = 0; i < 5; i++) {
      this.listaAno.push(String(this.anoAtual + i));
    }
  }

  onFormSubmit(value: any):void{
    console.log(this.myControl.value);

 
  }

}
