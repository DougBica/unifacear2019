import { Component, OnInit } from '@angular/core';
import { Aeronave } from '../model/aeronave.model';
import { AeronaveService } from '../aeronave.service';

@Component({
  selector: 'app-aeronave-listar',
  templateUrl: './aeronave-listar.component.html',
  styleUrls: ['./aeronave-listar.component.scss']
})
export class AeronaveListarComponent implements OnInit {

  aeronaves : Aeronave[];

  constructor(private aeronaveService : AeronaveService) { }

  ngOnInit() {
    this.load();
  }

  load() {
      console.log("Listar aeronaves");
      this.aeronaveService.list().subscribe(
       aeronaves => this.aeronaves = aeronaves
      )
  }

}
