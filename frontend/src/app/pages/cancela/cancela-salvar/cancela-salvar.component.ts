import { Component, OnInit } from '@angular/core';
import { Cancela } from '../model/cancela.model';
import { CancelaService } from '../cancela.service';
import { Router } from '@angular/router';
import { formatDate, DatePipe } from '@angular/common';


@Component({
  selector: 'app-cancela-salvar',
  templateUrl: './cancela-salvar.component.html',
  styleUrls: ['./cancela-salvar.component.scss']
})
export class CancelaSalvarComponent implements OnInit {

  cancela: Cancela = new Cancela()
  data: any = new Date();

  constructor(private service: CancelaService, private router: Router, ) { }
  ngOnInit() {
  }
  salvar() {
    this.cancela.dataCancelamento = formatDate(this.data, 'dd/MM/yyyy HH:mm', 'en-US')
    this.service.save(this.cancela).subscribe(
      () => {
        this.router.navigate(["/admin/cancela"])
      }
    )
  }

}
