import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../../usuario/model/usuario.model';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  
  usuario: Usuario = new Usuario();

  constructor(private route: ActivatedRoute,
    private registerService: RegisterService,
    private router: Router) { }

  ngOnInit() {
  }

  salvar() {
    this.registerService.salvar(this.usuario).subscribe(
      () => {


        this.router.navigate(["/login/"])
      }
    );
  }

}
