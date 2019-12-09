import { Component, OnInit, Input } from '@angular/core';
import { CancelaService } from '../cancela.service';
import { Cancela } from '../model/cancela.model';
import { Router, ActivatedRoute } from '@angular/router';
import { PassagemService } from '../../passagem/service/passagem.service';
import { Passagem } from '../../passagem/model/passagem.model';

@Component({
  selector: 'app-cancela-listar',
  templateUrl: './cancela-listar.component.html',
  styleUrls: ['./cancela-listar.component.scss'],

})
export class CancelaListarComponent implements OnInit {
  
  passagens: Passagem[]

  constructor(private router: Router, private service: PassagemService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.find()
  }
  find() {
    this.service.listAll().subscribe(
      passagens => this.passagens = passagens
    )
  }
  detail(guidPassagem) {
    this.router.navigate(["/admin/passagem/alterar/"+guidPassagem])
  }
}
