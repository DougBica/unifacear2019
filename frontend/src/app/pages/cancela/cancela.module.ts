import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CancelaListarComponent } from './cancela-listar/cancela-listar.component';
import { CancelaDetalhesComponent } from './cancela-detalhes/cancela-detalhes.component';
import { CancelaSalvarComponent } from './cancela-salvar/cancela-salvar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [CancelaListarComponent, CancelaDetalhesComponent, CancelaSalvarComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class CancelaModule { }
