import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logar',
  templateUrl: './logar.component.html',
  styleUrls: ['./logar.component.scss']
})
export class LogarComponent implements OnInit {

  constructor(private loginService : LoginService, private router : Router) { }

  ngOnInit() {
  }

  login: string;
  senha: string;

  submit() {
    console.log(this.login + " " + this.senha);
    this.loginService.login(this.login,this.senha).subscribe(
      user => {
        localStorage.setItem("token",user['token']);
        alert('logou');
        //redirecionar para o dashboard
      }
    )
  }

}
