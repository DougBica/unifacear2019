import { Component, OnInit, OnDestroy } from '@angular/core';
import { LoginService } from '../../login/login.service';
import { Router } from '@angular/router';
import { UseExistingWebDriver } from 'protractor/built/driverProviders';

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
    this.loginService.login(this.login,this.senha).subscribe(
      user => {
        localStorage.setItem("token",user['token']);
        localStorage.setItem("id",user['id']);
        console.log(user);
        if (user = 'ADMIN') {
          console.log("ADM")
          this.router.navigate(['/']);
        } else {
          console.log("Cliente")
          this.router.navigate(['/buscar-passagem']);
        }
      }
    )

  }

  logout() {
      localStorage.clear();
  }

}
