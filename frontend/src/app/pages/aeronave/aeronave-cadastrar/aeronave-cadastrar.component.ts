import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Aeronave } from '../model/aeronave.model';
import { AeronaveService } from '../aeronave.service';
import { FabricanteService } from '../../fabricante/model/fabricante.service';
import { Fabricante } from '../../fabricante/model/fabricante.model';
import { Assento } from '../../assento/model/assento.model';




@Component({
  selector: 'app-Aeronave-cadastrar',
  templateUrl: './aeronave-cadastrar.component.html',
  styleUrls: ['./aeronave-cadastrar.component.scss']
})
export class AeronaveCadastrarComponent implements OnInit {

  aeronave: Aeronave = new Aeronave();
  fabricante: Fabricante = new Fabricante();

  AeronaveService: any;
  FabricanteService: any;
  AssentoService: any;

  assentos: Assento[] = [];
  fabricantes: Fabricante[] = [];

  constructor(private route: ActivatedRoute,
    private aeronaveService: AeronaveService,
    private fabricanteService: FabricanteService,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidaeronave = params.get('id');
        this.aeronaveService.buscarPorId(guidaeronave).subscribe(
          aeronave => {
            this.aeronave = aeronave;
            this.assentos = aeronave.assentos;
            //console.log(this.aeronave);
          }
        );
      }
    });
    this.loadFabricantes();
  }

  salvar() {
    this.aeronave.assentos = this.assentos;

    console.log(this.aeronave);
    this.aeronaveService.salvar(this.aeronave).subscribe(
      () => {
        this.router.navigate(["/admin/aeronave/"]);
      }
    );


  }


  adicionarAssento() {
    let assento = new Assento()
    this.assentos.push(assento);
  }

  removerAssento(index: any) {
    this.assentos.splice(index, 1);
  }

  removerAeronave(index: any) {
    this.aeronave.splice(index, 1);
  }



  loadFabricantes() {
    this.fabricanteService.list().subscribe(
      fabricantes => this.fabricantes = fabricantes
    )
  }
}