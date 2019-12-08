import { Component, OnInit } from '@angular/core';
import { Embarque } from '../model/embarque.model';
import { EmbarqueService } from '../embarque.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-embarque-listar',
  templateUrl: './embarque-listar.component.html',
  styleUrls: ['./embarque-listar.component.scss']
})
export class EmbarqueListarComponent implements OnInit {

  embarques: Embarque[];

  constructor(private embarqueService: EmbarqueService, private toastr: ToastrService, private router: Router) { }

  ngOnInit() {
    this.load();
  }

  load() {
    this.embarqueService.load().subscribe(
      embarques => {
        this.embarques = embarques;
      }
    );
  }

  finalizar(embarque: Embarque) {
    embarque.embarcouIdf = 'Sim'
    this.embarqueService.save(embarque).subscribe(
      () => {
        
      }
    )
  }
  
  encontrarEmbarque(id: number) {
    console.log(id);
    if(id == null) {
      this.load();
    }
    this.embarqueService.loadByCheckin(id).subscribe(
      embarques => {
        this.embarques = embarques;
      }
    );
  }

}
