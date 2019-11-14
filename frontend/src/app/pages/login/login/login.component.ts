import { Component, OnInit, OnDestroy } from '@angular/core';
import { LoginService } from '../../login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {
  constructor(private loginService : LoginService, private router : Router) { }
  

  ngOnInit() {
  }
  ngOnDestroy() {
  }

  login: string;
  senha: string;

  submit() {
    console.log(this.login + " " + this.senha);
    this.loginService.login(this.login,this.senha).subscribe(
      user => {
        localStorage.setItem("token",user['token']);
        this.router.navigate(['/']);
      }
    )

  }

  logout() {
      localStorage.clear();
  }

}
