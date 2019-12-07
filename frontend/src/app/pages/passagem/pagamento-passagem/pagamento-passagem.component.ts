import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { PassagemService } from '../service/passagem.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { ValidadorCPF } from '../util/ValidadorCPF';
import { Usuario } from '../../usuario/model/usuario.model';


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
  usuario: Usuario;

  constructor(
    private fb: FormBuilder,
    private passagemService: PassagemService
    ) {}
    
    
    ngOnInit() {
      this.dadosPagamento = this.fb.group({
        nome: ['',[Validators.required]],
        numeroCartao: ['',Validators.compose([
                            Validators.required,
                            Validators.minLength(16)
                          ])],
        codigoCartao: ['',Validators.compose([
                            Validators.required,
                            Validators.minLength(3)
                          ])],
        cpf: ['',Validators.compose([
                  Validators.required,
                  Validators.minLength(10),
                  ValidadorCPF.isValidCpf()
                ])],
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
          this.buscarUsuario()
          .then(retorno => this.salvarPassagens(retorno)
            .then(() => alert("Pagamento realizado com sucesso")));
        }else{
          alert("Problema ao realizar o pagamento. Operação cancelada !!")
        }
      }
  }

  salvarPassagens(usuario){
    return new Promise((resolve,reject) => {
      this.passagemService.salvarReserva(localStorage.getItem("listaPassagens"),usuario).pipe(
      catchError(this.handleError)
    ).subscribe(() => resolve())
    })
  }

  buscarUsuario(){
    return new Promise((resolve,reject) => {
      this.passagemService.buscaUsuarioByEmail(this.getEmailJwt()).pipe(
      catchError(this.handleError)
    ).subscribe(retorno => resolve(this.usuario = retorno))
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
    if(error.status == 400){
      errorMessage = `Inconformidade nos dados, tente novamente`
    }else{
      errorMessage = `Erro no servidor, contate o suporte`
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
 }

 getEmailJwt(){
   let token = localStorage.getItem('token');
   let dados = token.split('.')[1]
   let dadosUser = JSON.parse(window.atob(dados))
   let email = dadosUser.sub;
   return email;
 }
}
