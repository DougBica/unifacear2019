import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CancelaService } from '../cancela.service';
import { Cancela } from '../model/cancela.model';

@Component({
  selector: 'app-cancela-detalhes',
  templateUrl: './cancela-detalhes.component.html',
  styleUrls: ['./cancela-detalhes.component.scss'],
})
export class CancelaDetalhesComponent implements OnInit {

  cancela: Cancela = new Cancela()
  nomeUsuario: string

  constructor(private route: ActivatedRoute, private router: Router, private service: CancelaService) {

  }
  ngOnInit() {
    const nav = this.router.getCurrentNavigation();
    console.log(nav.extras.state.cancela)
    if (nav.extras.state == null) {
      this.back()
    }
    else {
      this.cancela = nav.extras.state.cancela;
    }
  }
  back() {
    this.router.navigate(["/admin/passagem/alterar"])
  }
  deletar() {
    this.service.delete(this.cancela.guidCancelar + "").subscribe(
      () => {
        this.back()
      }
    )
  }
}
