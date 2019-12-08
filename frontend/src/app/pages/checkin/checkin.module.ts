import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckinListarComponent } from './checkin-listar/checkin-listar.component';
import { CheckinCadastrarComponent } from './checkin-cadastrar/checkin-cadastrar.component';
import { FormsModule } from '@angular/forms';
import { CheckinMenuComponent } from './checkin-menu/checkin-menu.component';
import { CheckinPassageiroComponent } from './checkin-passageiro/checkin-passageiro.component';

@NgModule({
  declarations: [CheckinListarComponent, CheckinCadastrarComponent, CheckinMenuComponent, CheckinPassageiroComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class CheckinModule { }
