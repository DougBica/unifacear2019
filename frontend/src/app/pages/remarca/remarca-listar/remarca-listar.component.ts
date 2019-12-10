import { Component, OnInit } from '@angular/core';
import { RemarcaService } from '../remarca.service';
import { Remarca } from '../model/remarca.model';

@Component({
  selector: 'app-remarca-listar',
  templateUrl: './remarca-listar.component.html',
  styleUrls: ['./remarca-listar.component.scss']
})
export class RemarcaListarComponent implements OnInit {
  remarcacoes: Remarca[]
  constructor(private service: RemarcaService) { }

  ngOnInit() {
    this.find()
  }
  find(){
    this.service.find().subscribe(
      remarcacoes => this.remarcacoes = remarcacoes
    )
  }

}
