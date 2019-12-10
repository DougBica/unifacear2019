import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Usuario } from '../model/usuario.model';
import { UsuarioService } from '../usuario.service';
import { Perfil } from '../../perfil1/model/perfil.model';
import { PerfilService } from '../../perfil1/perfil.service';
import { ArquivoService } from 'src/app/arquivo.service';
import { ValidadorCPF } from 'src/app/pages/passagem/util/ValidadorCPF';

@Component({
  selector: 'app-usuario-cadastrar',
  templateUrl: './usuario-cadastrar.component.html',
  styleUrls: ['./usuario-cadastrar.component.scss']
})
export class UsuarioCadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario();

  perfis: Perfil[] = [];

  input: any;

  fileToUpload: File = null;

  constructor(private route: ActivatedRoute,
    private usuarioService: UsuarioService,
    private perfilService: PerfilService,
    private fb: FormBuilder,
    private arquivoService: ArquivoService,
    private router: Router) { }

  ngOnInit() {
    this.load();
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidUsuario = params.get('id');
        this.usuarioService.buscarPorID(guidUsuario).subscribe(
          usuario => {
            this.usuario = usuario;
            this.usuario.AlterarSenha = false;
        
            //console.log(this.usuario);
          }
        );
      }
    });
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);

    this.usuarioService.upload(this.fileToUpload).subscribe(
      arquivo => {
        this.usuario.foto = arquivo.guidArquivo;
      }
    );
  }

  load() {
    this.perfilService.list().subscribe(
      perfis => {
        console.log(perfis);
        this.perfis = perfis
      }
    )
  }

  salvar() {
    console.log(this.perfis);
    console.log(this.usuario);


    this.usuarioService.salvar(this.usuario).subscribe(
      () => {

        console.log(this.usuario);

      }
    );
    if(localStorage.getItem("typeUser") == "ADMIN"){
      this.router.navigate(["/admin/usuario"]);
    }
    else{
      this.router.navigate(["/cliente/buscar-passagem"])
      
    } ; 
  }
  ModalSenha(){
    this.usuario.AlterarSenha = true;
  }
  upload(input: any) {
    this.input = input;
  }


}
