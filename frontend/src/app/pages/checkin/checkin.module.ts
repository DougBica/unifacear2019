import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckinListarComponent } from './checkin-listar/checkin-listar.component';
import { CheckinCadastrarComponent } from './checkin-cadastrar/checkin-cadastrar.component';
import { FormsModule } from '@angular/forms';
import { CheckinMenuComponent } from './checkin-menu/checkin-menu.component';

@NgModule({
  declarations: [CheckinListarComponent, CheckinCadastrarComponent, CheckinMenuComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class CheckinModule { }
