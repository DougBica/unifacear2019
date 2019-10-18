import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AeronaveListarComponent } from './aeronave-listar/aeronave-listar.component';
import { AeronaveCadastrarComponent } from './aeronave-cadastrar/aeronave-cadastrar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AeronaveListarComponent, AeronaveCadastrarComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class AeronaveModule { }
