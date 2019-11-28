import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AeroportoService } from '../aeroporto.service';
import { Aeroporto } from '../model/aeroporto.model';



@Component({
  selector: 'app-aeroporto-cadastrar',
  templateUrl: './aeroporto-cadastrar.component.html',
  styleUrls: ['./aeroporto-cadastrar.component.scss']
})
export class AeroportoCadastrarComponent implements OnInit {

  aeroporto: Aeroporto = new Aeroporto();

  constructor(private route: ActivatedRoute,
    private aeroportoService: AeroportoService,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidAeroporto = params.get('id');
        this.aeroportoService.buscarPorID(guidAeroporto).subscribe(
          aeroporto => {
            this.aeroporto = aeroporto;
          }
        );
      }
    });
  }
  salvar() {
    this.aeroportoService.salvar(this.aeroporto).subscribe(
      () => {


        this.router.navigate(["/admin/aeroporto/"]);
      }
    );
  }

}
