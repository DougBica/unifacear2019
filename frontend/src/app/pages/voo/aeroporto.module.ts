import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AeroportoListarComponent } from './aeroporto-listar/aeroporto-listar.component';
import { AeroportoCadastrarComponent } from './aeroporto-cadastrar/aeroporto-cadastrar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AeroportoListarComponent, AeroportoCadastrarComponent],

  imports: [
    CommonModule,
    FormsModule
  ]
})
export class AeroportoModule { }
