import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Fabricante } from '../model/fabricante.model';
import { FabricanteService } from '../fabricante.service';



@Component({
  selector: 'app-Fabricante-cadastrar',
  templateUrl: './fabricante-cadastrar.component.html',
  styleUrls: ['./fabricante-cadastrar.component.scss']
})
export class FabricanteCadastrarComponent implements OnInit {

  fabricante: Fabricante = new Fabricante();
  FabricanteveService: any;

  constructor(private route: ActivatedRoute, 
    private fabricanteService : FabricanteService,
    private router : Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidFabricante = params.get('id');
        this.fabricanteService.buscarPorId(guidFabricante).subscribe(
          fabricante => {
              this.fabricante = fabricante;
              console.log(this.fabricante);
          }
        );
      }
    });
  }

  salvar() {
    this.fabricanteService.salvar(this.fabricante).subscribe(
      () => {
        this.router.navigate(["/admin/fabricante/"]);    
      }
    );
  }

}
