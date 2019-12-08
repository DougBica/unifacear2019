import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmbarqueListarComponent } from './embarque-listar/embarque-listar.component';
import { EmbarqueCadastrarComponent } from './embarque-cadastrar/embarque-cadastrar.component';
import { FormsModule } from '@angular/forms';
import { NgxMaskModule } from 'ngx-mask';

@NgModule({
  declarations: [EmbarqueListarComponent, EmbarqueCadastrarComponent],
  imports: [
    CommonModule,
    FormsModule,
    NgxMaskModule
  ]
})
export class EmbarqueModule { }
