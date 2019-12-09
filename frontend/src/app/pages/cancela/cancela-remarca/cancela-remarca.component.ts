import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cancela-remarca',
  templateUrl: './cancela-remarca.component.html',
  styleUrls: ['./cancela-remarca.component.scss']
})
export class CancelaRemarcaComponent implements OnInit {

  guidPassagem: any

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        this.guidPassagem = params.get('id');
      }
    });
  }
  cancelar() {
    this.router.navigate(["/admin/cancela/salvar/"+this.guidPassagem])
  }
  remarcar() {
    this.router.navigate(["/admin/remarca/salvar/"+this.guidPassagem])
  }
  voltar(){
    this.router.navigate(["/admin/passagem/alterar"])
  }
}
