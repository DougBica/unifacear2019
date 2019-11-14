import { Component, OnInit } from '@angular/core';
import { Bagagem } from '../model/bagagem.model';
import { BagagemService } from '../bagagem.service';

@Component({
  selector: 'app-bagagem-listar',
  templateUrl: './bagagem-listar.component.html',
  styleUrls: ['./bagagem-listar.component.scss']
})
export class BagagemListarComponent implements OnInit {

  bagagens: Bagagem[];

  constructor() { }

  ngOnInit() {
  }

}
