import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Usuario } from '../model/usuario.model';
import { UsuarioService } from '../usuario.service';
import { Perfil } from '../model/perfil.model';
import { ArquivoService } from 'src/app/arquivo.service';


@Component({
  selector: 'app-usuario-cadastrar',
  templateUrl: './usuario-cadastrar.component.html',
  styleUrls: ['./usuario-cadastrar.component.scss']
})
export class UsuarioCadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario();

  perfis: Perfil[] = [];

  input : any;

  constructor(private route: ActivatedRoute,
    private usuarioService: UsuarioService,
    private arquivoService: ArquivoService,
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

    this.arquivoService.salvar(this.input.files[0]).subscribe(
      arquivo => {
        console.log(arquivo);
      }
    );

    //this.usuario.perfis = this.perfis;
    //console.log(this.usuario);
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

  upload(input : any) {
    this.input = input;
  }

}
