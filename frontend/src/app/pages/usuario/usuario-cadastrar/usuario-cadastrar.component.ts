import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Usuario } from '../model/usuario.model';
import { UsuarioService } from '../usuario.service';
import { Perfil } from '../../perfil/model/perfil.model';


@Component({
  selector: 'app-usuario-cadastrar',
  templateUrl: './usuario-cadastrar.component.html',
  styleUrls: ['./usuario-cadastrar.component.scss']
})
export class UsuarioCadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario();

  perfis: Perfil[] = [];

  constructor(private route: ActivatedRoute,
    private usuarioService: UsuarioService,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidUsuario = params.get('id');
        this.usuarioService.buscarPorID(guidUsuario).subscribe(
          usuario => {
            this.usuario = usuario;
            //console.log(this.usuario);
          }
        );
      }
    });
  }

  salvar() {
    this.usuario.perfis = this.perfis;
    console.log(this.usuario);
    /*this.usuarioService.salvar(this.usuario).subscribe(
      () => {


        this.router.navigate(["/admin/usuario/"]);
      }
    );*/
  }

  adicionarPerfil() {
    let perfil = new Perfil()   
    this.perfis.push(perfil);    
  }

  removerPerfil(index : any) {
    this.perfis.splice(index, 1);
  }

}
