import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CarrinhoPassagemComponent } from './carrinho-passagem/carrinho-passagem.component';
import { BuscarPassagemComponent } from './buscar-passagem/buscar-passagem.component';
import { PagamentoPassagemComponent } from './pagamento-passagem/pagamento-passagem.component';

@NgModule({
  declarations: [
    CarrinhoPassagemComponent, 
    BuscarPassagemComponent, 
    PagamentoPassagemComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PassagemModule { }
