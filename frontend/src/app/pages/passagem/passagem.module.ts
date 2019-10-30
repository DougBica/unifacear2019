import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { CarrinhoPassagemComponent } from './carrinho-passagem/carrinho-passagem.component';
import { BuscarPassagemComponent } from './buscar-passagem/buscar-passagem.component';
import { PagamentoPassagemComponent } from './pagamento-passagem/pagamento-passagem.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    CarrinhoPassagemComponent, 
    BuscarPassagemComponent, 
    PagamentoPassagemComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    BrowserModule,
    ReactiveFormsModule
  ]
})
export class PassagemModule { }
