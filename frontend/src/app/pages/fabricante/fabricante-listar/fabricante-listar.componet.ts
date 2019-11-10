import { Component, OnInit } from '@angular/core';
import { Fabricante } from '../model/fabricante.model';
import { FabricanteService } from '../model/fabricante.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fabricante-listar',
  templateUrl: './fabricante-listar.component.html',
  styleUrls: ['./fabricante-listar.component.scss']
})
export class FabricanteListarComponent implements OnInit {

  fabricantes : Fabricante[];
  
  FabricanteService: any;

  constructor(private fabricanteService : FabricanteService,
    private router : Router) { }

  ngOnInit() {
    this.load();
  }

  load() {
      console.log("Listar fabricantes");
      this.fabricanteService.list().subscribe(
       fabricantes => this.fabricantes = fabricantes
      )
  }

  edit(fabricante: Fabricante) {
    this.router.navigate(["/admin/fabricante/"+fabricante.guidFabricante]);    
  }


  deleteFabricante(fabricante: Fabricante) {
    this.fabricanteService.remover(fabricante).subscribe(
      data => {
        this.load();
      }
    );
  }


}
