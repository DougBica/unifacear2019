import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CancelaListarComponent } from './cancela-listar/cancela-listar.component';
import { CancelaDetalhesComponent } from './cancela-detalhes/cancela-detalhes.component';
import { CancelaSalvarComponent } from './cancela-salvar/cancela-salvar.component';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material' 

@NgModule({
  declarations: [CancelaListarComponent, CancelaDetalhesComponent, CancelaSalvarComponent],
  imports: [
    CommonModule,
    FormsModule,
    MatTableModule
  ]
})
export class CancelaModule { }
