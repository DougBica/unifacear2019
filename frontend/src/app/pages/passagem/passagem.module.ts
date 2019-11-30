import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

import { CarrinhoPassagemComponent } from './carrinho-passagem/carrinho-passagem.component';
import { BuscarPassagemComponent } from './buscar-passagem/buscar-passagem.component';
import { PagamentoPassagemComponent } from './pagamento-passagem/pagamento-passagem.component';
import { ReactiveFormsModule } from '@angular/forms';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field'
import {MatNativeDateModule} from '@angular/material'
import {MatInputModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BsDropdownModule, BsDropdownConfig } from 'ngx-bootstrap/dropdown';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import {NumberPickerModule} from 'ng-number-picker';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { ModalModule } from 'ngx-bootstrap/modal';
import { ModalLoginComponent } from './modalLogin/modal-login.component';


@NgModule({
  declarations: [
    CarrinhoPassagemComponent, 
    BuscarPassagemComponent, 
    PagamentoPassagemComponent,
    ModalLoginComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    NgbModule,
    BrowserModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,  
    BrowserAnimationsModule,
    BsDatepickerModule.forRoot(),
    BsDropdownModule.forRoot(),
    ButtonsModule.forRoot(), 
    NumberPickerModule, 
    CarouselModule,
    ModalModule.forRoot()
  ],
  entryComponents: [ModalLoginComponent]
})
export class PassagemModule { }
