import { Component, OnInit, OnDestroy } from '@angular/core';
import { LoginService } from '../../login/login.service';
import { Router } from '@angular/router';
import { UseExistingWebDriver } from 'protractor/built/driverProviders';
import { UsuarioService } from '../../usuario/usuario.service';
import { Usuario } from '../../usuario/model/usuario.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {
  constructor(private loginService : LoginService, private router : Router, private usuarioService: UsuarioService) { }
  

  ngOnInit() {
  }
  ngOnDestroy() {
  }

  login: string;
  senha: string;
  usuario: Usuario;

  submit() {
    this.loginService.login(this.login,this.senha).subscribe(
      user => {
        localStorage.setItem("token",user['token']);
        localStorage.setItem("id",user['id']);
        this.usuarioService.buscarPorID(localStorage.getItem("id")).subscribe(
          usuario => {
            this.usuario = usuario;
            if (this.usuario.tipoDeUsuarios == "ADMIN") {
              this.router.navigate(["cliente/buscar-passagem"])
              localStorage.setItem("typeUser",'ADMIN');
            } else {
              this.router.navigate(["cliente/buscar-passagem"])
              localStorage.setItem("typeUser",'CLIENTE');
            }
          }
        );
      }
    )

  }

  logout() {
      localStorage.clear();
  }

  register() {
    this.router.navigate(['/register']);
  }

}
