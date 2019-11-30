import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RemarcaSalvarComponent } from './remarca-salvar/remarca-salvar.component';
import { RemarcaListarComponent } from './remarca-listar/remarca-listar.component';

@NgModule({
  declarations: [RemarcaSalvarComponent, RemarcaListarComponent],
  imports: [
    CommonModule
  ]
})
export class RemarcaModule { }
