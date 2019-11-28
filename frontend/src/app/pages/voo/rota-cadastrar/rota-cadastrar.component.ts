import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Rota } from '../model/rota.model';
import { RotaService } from '../rota.service';



@Component({
  selector: 'app-rota-cadastrar',
  templateUrl: './rota-cadastrar.component.html',
  styleUrls: ['./rota-cadastrar.component.scss']
})
export class RotaCadastrarComponent implements OnInit {

  rota: Rota = new Rota();

  constructor(private route: ActivatedRoute,
    private rotaService: RotaService,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidRota = params.get('id');
        this.rotaService.buscarPorID(guidRota).subscribe(
          rota => {
            this.rota = rota;
          }
        );
      }
    });
  }

  salvar() {
    this.rotaService.salvar(this.rota).subscribe(
      () => {


        this.router.navigate(["/admin/rota/"]);
      }
    );
  }

}
