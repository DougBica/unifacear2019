import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario.model';
import { UsuarioService } from '../usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuario-listar',
  templateUrl: './usuario-listar.component.html',
  styleUrls: ['./usuario-listar.component.scss']
})
export class UsuarioListarComponent implements OnInit {
  
  usuarios : Usuario[];
  usuario : Usuario;

  constructor(private usuarioService : UsuarioService,
    private router : Router) { }

  ngOnInit() {
    this.load();
  }

  load() {      
      this.usuarioService.list().subscribe(
        usuarios => {
          console.log(usuarios);
          this.usuarios = usuarios
        }
      )

  }

  edit(usuario: Usuario) {
    this.router.navigate(["/admin/usuario/"+usuario.guidUsuario]);    
  }
  novo(usuario: Usuario) {
    this.router.navigate(["/admin/usuario/novo"])
  }
}
