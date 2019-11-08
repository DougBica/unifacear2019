import { Component, OnInit } from '@angular/core';
import { Aeronave } from '../model/aeronave.model';
import { AeronaveService } from '../aeronave.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aeronave-listar',
  templateUrl: './aeronave-listar.component.html',
  styleUrls: ['./aeronave-listar.component.scss']
})
export class AeronaveListarComponent implements OnInit {

  aeronaves : Aeronave[];
  
  AeronaveService: any;

  constructor(private aeronaveService : AeronaveService,
    private router : Router) { }

  ngOnInit() {
    this.load();
  }

  load() {
      console.log("Listar aeronaves");
      this.aeronaveService.list().subscribe(
       aeronaves => this.aeronaves = aeronaves
      )
  }

  edit(aeronave: Aeronave) {
    this.router.navigate(["/admin/aeronave/"+aeronave.guidaeronave]);    
  }

  deleteAeronave(aeronave: Aeronave) {
    this.aeronaveService.remover(aeronave).subscribe(
      data => {
        this.load();
      }
    );
  }

}
