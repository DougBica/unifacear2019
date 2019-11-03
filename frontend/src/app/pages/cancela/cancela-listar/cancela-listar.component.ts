import { Component, OnInit, Input } from '@angular/core';
import { CancelaService } from '../cancela.service';
import { Cancela } from '../model/cancela.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancela-listar',
  templateUrl: './cancela-listar.component.html',
  styleUrls: ['./cancela-listar.component.scss']
})
export class CancelaListarComponent implements OnInit {
  cancelamentos: Cancela[];

  constructor(private router: Router, private service: CancelaService) { }

  ngOnInit() {
    this.load()
  }
  load (){
    this.service.list().subscribe(
      cancelamentos => this.cancelamentos = cancelamentos
    )
  }
  
  detail(cancela: Cancela){
    //this.router.navigateByUrl("/admin/cancela/detalhes",{ state: {cancela: cancela}})
    this.router.navigate(["/admin/cancela/detalhes/"+cancela.guidCancelar])
  }
}
