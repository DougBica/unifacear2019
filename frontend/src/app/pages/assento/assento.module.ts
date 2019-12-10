import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AssentoCadastrarComponent } from './assento-cadastrar/assento-cadastrar.component';
import { AssentoListarComponent } from './assento-listar/assento-listar.component';

@NgModule({
  declarations: [AssentoCadastrarComponent,AssentoListarComponent],
  imports: [
    CommonModule
    
  ]
})
export class AssentoModule { }
