import { Component, OnInit, Input } from '@angular/core';
import { CancelaService } from '../cancela.service';
import { Cancela } from '../model/cancela.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancela-listar',
  templateUrl: './cancela-listar.component.html',
  styleUrls: ['./cancela-listar.component.css'],

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
   // this.router.navigate(["/admin/cancela/detalhes/"+cancela.guidCancelar])
    this.router.navigate(["/admin/cancela/detalhes"],
    { state: {cancela: cancela}})
  }
  salvar(){
    // init teste
    const cancela_teste = new Cancela()
    cancela_teste.guidReserva = 1
    cancela_teste.guidPassagem = 1
    cancela_teste.guidUsuario = 1
    cancela_teste.checkin = false
    // end teste*/
    this.router.navigate(["/admin/cancela/salvar"],
    { state: {cancela: cancela_teste}})
  }
}
