import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VooListarComponent } from './voo-listar/voo-listar.component';
import { VooCadastrarComponent } from './voo-cadastrar/voo-cadastrar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [VooListarComponent, VooCadastrarComponent],

  imports: [
    CommonModule,
    FormsModule
  ]
})
export class VooModule { }
