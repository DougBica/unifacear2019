import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmbarqueListarComponent } from './embarque-listar/embarque-listar.component';
import { EmbarqueCadastrarComponent } from './embarque-cadastrar/embarque-cadastrar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [EmbarqueListarComponent, EmbarqueCadastrarComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class EmbarqueModule { }
