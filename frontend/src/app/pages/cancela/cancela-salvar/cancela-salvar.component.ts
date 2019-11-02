import { Component, OnInit } from '@angular/core';
import { Cancela } from '../model/cancela.model';
import { CancelaService } from '../cancela.service';

@Component({
  selector: 'app-cancela-salvar',
  templateUrl: './cancela-salvar.component.html',
  styleUrls: ['./cancela-salvar.component.scss']
})
export class CancelaSalvarComponent implements OnInit {

cancela: Cancela = new Cancela()

  constructor(private service: CancelaService) { }

  ngOnInit() {
  }
  
  salvar(){
  console.log("Entrou 1")
   this.service.save(this.cancela).subscribe(
      () => {
        console.log("Entrou 2")
      }
    )
  }

}
