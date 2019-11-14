import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AeronaveListarComponent } from './aeronave-listar/aeronave-listar.component';
import { AeronaveCadastrarComponent } from './aeronave-cadastrar/aeronave-cadastrar.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [AeronaveListarComponent, AeronaveCadastrarComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule 
  ]
})
export class AeronaveModule { }
