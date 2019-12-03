import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { PassagemService } from '../service/passagem.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';


@Component({
  selector: 'app-pagamento-passagem',
  templateUrl: './pagamento-passagem.component.html',
  styleUrls: ['./pagamento-passagem.component.scss']
})
export class PagamentoPassagemComponent implements OnInit {

  anoAtual : any = new Date().getUTCFullYear();
  listaAno : any = [];
  listaMes : number [] = [1,2,3,4,5,6,7,8,9,10,11,12];
  listaCartoes: string [] = ["Visa", "Master Card", "American Express", "Elo"]
  dadosPagamento : FormGroup;

  constructor(
    private fb: FormBuilder,
    private passagemService: PassagemService
    ) {}
     
  
  ngOnInit() {
    this.dadosPagamento = this.fb.group({
      nome: ['',[Validators.required]],
      numeroCartao: ['',[Validators.required]],
      codigoCartao: ['',[Validators.required]],
      cpf: ['',[Validators.required]],
      bandeiraCartao:['',[Validators.required]],
      anoValidade: ['',[Validators.required]],
      mesValidade: ['',[Validators.required]]
    });

    for (let i = 0; i < 5; i++) {
      this.listaAno.push(String(this.anoAtual + i));
    }
  }

  onFormSubmit(){
    console.log(this.dadosPagamento.value, this.dadosPagamento.valid);
    if(this.dadosPagamento.valid){
      let confirmacao = this.creditCardServce(this.dadosPagamento.value);
      
      if (confirmacao) {
      this.salvarPassagens()
        .then(() => alert("Pagamento realizado com sucesso"));
      }else{
        alert("Problema ao realizar o pagamento. Operação cancelada !!")
      }
    }else{
        alert("Problema ao realizar o pagamento. Operação cancelada !!")
    }
  }

  salvarPassagens(){
    return new Promise((resolve,reject) => {
      this.passagemService.salvarReserva(localStorage.getItem("listaPassagens")).pipe(
      catchError(this.handleError)
    ).subscribe(() => resolve())
      reject()
    })
  }
  creditCardServce(creditCard){
    if(creditCard){
      return true;
    } return false;
  }
  
  handleError(error) {
    let errorMessage = '';
    if(error.status == 403){
      errorMessage = `Necessita estar logado no sistema`
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
 }
}
