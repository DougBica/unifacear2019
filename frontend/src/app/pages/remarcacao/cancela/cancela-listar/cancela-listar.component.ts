import { Component, OnInit } from '@angular/core';
import { Cancela } from '../model/cancela.model';

@Component({
  selector: 'app-cancela-listar',
  templateUrl: './cancela-listar.component.html',
  styleUrls: ['./cancela-listar.component.scss']
})
export class CancelaLIstarComponent implements OnInit {

cancela: Cancela;

  constructor() { }

  ngOnInit() {
    this.load();
  }

  load(){
    
  }

}
