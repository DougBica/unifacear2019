import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisterService } from '../../register/register.service';
import { PerfilService } from '../perfil.service';
import { Perfil } from '../model/perfil.model';
import { Permissao } from '../../usuario/model/permissao.model';

@Component({
  selector: 'app-perfil-cadastrar',
  templateUrl: './perfil-cadastrar.component.html',
  styleUrls: ['./perfil-cadastrar.component.scss']
})
export class PerfilCadastrarComponent implements OnInit {

  perfil: Perfil = new Perfil();

  permissoes: Permissao[] = [];
  constructor(private route: ActivatedRoute,
    private perfilservice: PerfilService,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidTipoPerfil = params.get('id');
        this.perfilservice.buscarPorID(guidTipoPerfil).subscribe(
          perfil => {
            this.perfil = perfil;
            console.log(this.perfil);
          }
        );
      }
    });
  }

  salvar() {
    this.perfil = this.perfil;
    console.log(this.perfil);

  }

  adicionarPermissao() {
    let permissao = Permissao.ACESSO;
    this.permissoes.push(permissao);
  }

  removerPermissao(index: any) {
    this.permissoes.splice(index, 1);
  }


}
