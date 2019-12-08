import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RemarcaSalvarComponent } from './remarca-salvar/remarca-salvar.component';
import { RemarcaListarComponent } from './remarca-listar/remarca-listar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [RemarcaSalvarComponent, RemarcaListarComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class RemarcaModule { }
