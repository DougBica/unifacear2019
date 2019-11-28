import { Component, OnInit } from '@angular/core';
import { Aeroporto } from '../model/aeroporto.model';
import { AeroportoService } from '../aeroporto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aeroporto-listar',
  templateUrl: './aeroporto-listar.component.html',
  styleUrls: ['./aeroporto-listar.component.scss']
})
export class AeroportoListarComponent implements OnInit {
  
  aeroporto : Aeroporto[];

  constructor(private aeroportoService : AeroportoService,
    private router : Router) { }

  ngOnInit() {
    this.load();
  }

  load() {      
      this.aeroportoService.list().subscribe(
        aeroporto => this.aeroporto = aeroporto
      )

  }

  edit( aeroporto: Aeroporto) {
    this.router.navigate(["/admin/aeroporto/"+ aeroporto.guidAeroporto]);    
  }
}
