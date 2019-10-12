import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckinListarComponent } from './checkin-listar/checkin-listar.component';
import { CheckinCadastrarComponent } from './checkin-cadastrar/checkin-cadastrar.component';

@NgModule({
  declarations: [CheckinListarComponent, CheckinCadastrarComponent],
  imports: [
    CommonModule
  ]
})
export class CheckinModule { }
