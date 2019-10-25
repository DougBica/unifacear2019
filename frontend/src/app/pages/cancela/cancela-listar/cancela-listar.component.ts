import { Component, OnInit } from '@angular/core';
import { CancelaService } from '../cancela.service';
import { Cancela } from '../model/cancela.model';

@Component({
  selector: 'app-cancela-listar',
  templateUrl: './cancela-listar.component.html',
  styleUrls: ['./cancela-listar.component.scss']
})
export class CancelaListarComponent implements OnInit {
  cancelamentos: Cancela[];
  constructor(private service: CancelaService) { }

  ngOnInit() {
    this.load()
  }
  load (){
    this.service.list().subscribe(
      cancelamentos => this.cancelamentos = cancelamentos
    )
  }

}
