import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmbarqueListarComponent } from './embarque-listar/embarque-listar.component';
import { EmbarqueCadastrarComponent } from './embarque-cadastrar/embarque-cadastrar.component';

@NgModule({
  declarations: [EmbarqueListarComponent, EmbarqueCadastrarComponent],
  imports: [
    CommonModule
  ]
})
export class EmbarqueModule { }
