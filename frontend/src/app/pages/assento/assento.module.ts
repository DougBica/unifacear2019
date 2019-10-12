import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AssentoListarComponent } from './assento-listar/assento-listar.component';
import { AssentoCadastrarComponent } from './assento-cadastrar/assento-cadastrar.component';

@NgModule({
  declarations: [AssentoListarComponent, AssentoCadastrarComponent],
  imports: [
    CommonModule
  ]
})
export class AssentoModule { }
