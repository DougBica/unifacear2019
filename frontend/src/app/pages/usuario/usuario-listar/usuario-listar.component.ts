import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario.model';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-usuario-listar',
  templateUrl: './usuario-listar.component.html',
  styleUrls: ['./usuario-listar.component.scss']
})
export class UsuarioListarComponent implements OnInit {

  usuarios : Usuario[];

  constructor(private usuarioService : UsuarioService) { }

  ngOnInit() {
    this.load();
  }

  load() {
      console.log("Listar usuários");
      this.usuarioService.list().subscribe(
        usuarios => this.usuarios = usuarios
      )
  }

}
