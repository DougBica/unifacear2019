import { Component, OnInit, Input } from '@angular/core';
import { CancelaService } from '../cancela.service';
import { Cancela } from '../model/cancela.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cancela-listar',
  templateUrl: './cancela-listar.component.html',
  styleUrls: ['./cancela-listar.component.scss'],

})
export class CancelaListarComponent implements OnInit {
  cancelamentos: Cancela[];
  constructor(private router: Router, private service: CancelaService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    let idPassagem
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        idPassagem = params.get('id');
      }
    });
    // this.find()
    this.findByGuidUsuario(idPassagem)

  }
  find() {
    this.service.list().subscribe(
      cancelamentos => this.cancelamentos = cancelamentos
    )
  }
  findByGuidUsuario(id) {
    console.log(id)
    this.service.findByidGuidUsuario(id).subscribe(
      cancelamentos => this.cancelamentos = cancelamentos
    )
  }
  detail(cancela: Cancela) {
    // this.router.navigate(["/admin/cancela/detalhes/"+cancela.guidCancelar])
    this.router.navigate(["/admin/cancela/detalhes"],
      { state: { cancela: cancela } })
  }
}
