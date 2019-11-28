import { Component, OnInit } from '@angular/core';
import { Rota } from '../model/rota.model';
import { RotaService } from '../rota.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rota-listar',
  templateUrl: './rota-listar.component.html',
  styleUrls: ['./rota-listar.component.scss']
})
export class RotaListarComponent implements OnInit {
  
  rota : Rota[];

  constructor(private rotaService : RotaService,
    private router : Router) { }

  ngOnInit() {
    this.load();
  }

  load() {      
      this.rotaService.list().subscribe(
        rota => this.rota = rota
      )

  }

  edit(rota: Rota) {
    this.router.navigate(["/admin/rota/"+ rota.guidRota]);    
  }
}
