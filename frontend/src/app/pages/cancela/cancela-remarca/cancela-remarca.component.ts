import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Passagem } from '../../passagem/model/passagem.model';
import { PassagemService } from '../../passagem/service/passagem.service';

@Component({
  selector: 'app-cancela-remarca',
  templateUrl: './cancela-remarca.component.html',
  styleUrls: ['./cancela-remarca.component.scss']
})
export class CancelaRemarcaComponent implements OnInit {

  passagem: Passagem = new Passagem()
  guidPassagem: any

  constructor(private router: Router,
    private route: ActivatedRoute,
    private servicePassagem: PassagemService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        this.guidPassagem = params.get('id');
        this.servicePassagem.listById(this.guidPassagem).subscribe(
          passagem => this.passagem = passagem
        )
      }
    });
  }
  cancelar() {
    this.router.navigate(["/admin/cancela/salvar/" + this.guidPassagem])
  }
  remarcar() {
    this.router.navigate(["/admin/remarca/salvar/" + this.guidPassagem])
  }
  voltar() {
    this.router.navigate(["/admin/passagem/alterar"])
  }
}
