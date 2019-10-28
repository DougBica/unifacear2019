import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarrinhoPassagemComponent } from './carrinho-passagem/carrinho-passagem.component';
import { BuscarPassagemComponent } from './buscar-passagem/buscar-passagem.component';

@NgModule({
  declarations: [CarrinhoPassagemComponent, BuscarPassagemComponent],
  imports: [
    CommonModule
  ]
})
export class PassagemModule { }
