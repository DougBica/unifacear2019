import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckinListarComponent } from './checkin-listar/checkin-listar.component';
import { CheckinCadastrarComponent } from './checkin-cadastrar/checkin-cadastrar.component';
import { FormsModule } from '@angular/forms';
import { CheckinMenuComponent } from './checkin-menu/checkin-menu.component';
import { CheckinPassageiroComponent } from './checkin-passageiro/checkin-passageiro.component';
import { NgxMaskModule } from 'ngx-mask';
import { CheckinInformacoesComponent } from './checkin-informacoes/checkin-informacoes.component';
import { QRCodeModule } from 'angular2-qrcode';

@NgModule({
  declarations: [CheckinListarComponent, CheckinCadastrarComponent, CheckinMenuComponent, CheckinPassageiroComponent, CheckinInformacoesComponent],
  imports: [
    CommonModule,
    FormsModule,
    NgxMaskModule,
    QRCodeModule
  ]
})
export class CheckinModule { }
