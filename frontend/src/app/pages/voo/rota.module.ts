import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RotaListarComponent } from './rota-listar/rota-listar.component';
import { RotaCadastrarComponent } from './rota-cadastrar/rota-cadastrar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [RotaListarComponent, RotaCadastrarComponent],

  imports: [
    CommonModule,
    FormsModule
  ]
})
export class RotaModule { }
