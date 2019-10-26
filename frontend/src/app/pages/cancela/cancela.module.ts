import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CancelaListarComponent } from './cancela-listar/cancela-listar.component';
import { CancelaDetalhesComponent } from './cancela-detalhes/cancela-detalhes.component';

@NgModule({
  declarations: [CancelaListarComponent, CancelaDetalhesComponent],
  imports: [
    CommonModule
  ]
})
export class CancelaModule { }
