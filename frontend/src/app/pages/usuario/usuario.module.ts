import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioListarComponent } from './usuario-listar/usuario-listar.component';
import { UsuarioCadastrarComponent } from './usuario-cadastrar/usuario-cadastrar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [UsuarioListarComponent, UsuarioCadastrarComponent],

  imports: [
    CommonModule,
    FormsModule
  ]
})
export class UsuarioModule { }
