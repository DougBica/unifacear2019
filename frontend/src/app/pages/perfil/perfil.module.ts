import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerfilCadastrarComponent } from './perfil-cadastrar/perfil-cadastrar.component';
import { PerfilListarComponent } from './perfil-listar/perfil-listar.component';

@NgModule({
  declarations: [PerfilCadastrarComponent, PerfilListarComponent],
  imports: [
    CommonModule
  ]
})
export class PerfilModule { }
