import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckinListarComponent } from './checkin-listar/checkin-listar.component';
import { CheckinCadastrarComponent } from './checkin-cadastrar/checkin-cadastrar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [CheckinListarComponent, CheckinCadastrarComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class CheckinModule { }
