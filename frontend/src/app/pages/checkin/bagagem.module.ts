import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BagagemCadastrarComponent } from './bagagem-cadastrar/bagagem-cadastrar.component';
import { BagagemListarComponent } from './bagagem-listar/bagagem-listar.component';

@NgModule({
  declarations: [BagagemCadastrarComponent, BagagemListarComponent],
  imports: [
    CommonModule
  ]
})
export class BagagemModule { }
