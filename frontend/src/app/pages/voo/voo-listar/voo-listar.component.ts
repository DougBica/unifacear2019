import { Component, OnInit } from '@angular/core';
import { Voo } from '../model/voo.model';
import { VooService } from '../voo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-voo-listar',
  templateUrl: './voo-listar.component.html',
  styleUrls: ['./voo-listar.component.scss']
})
export class VooListarComponent implements OnInit {
  
  voo : Voo[];

  constructor(private vooService : VooService,
    private router : Router) { }

  ngOnInit() {
    this.load();
  }

  load() {      
      this.vooService.list().subscribe(
        voo => this.voo = voo
      )

  }

  edit(voo: Voo) {
    this.router.navigate(["/admin/voo/"+ voo.guidVoo]);    
  }
}
