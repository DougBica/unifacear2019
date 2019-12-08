import { Component, OnInit } from '@angular/core';
import { Cancela } from '../model/cancela.model';
import { CancelaService } from '../cancela.service';
import { Router, ActivatedRoute } from '@angular/router';
import { formatDate, DatePipe } from '@angular/common';
import { Passagem } from '../../passagem/model/passagem.model';
import { PassagemService } from '../../passagem/service/passagem.service';


@Component({
  selector: 'app-cancela-salvar',
  templateUrl: './cancela-salvar.component.html',
  styleUrls: ['./cancela-salvar.component.scss']
})
export class CancelaSalvarComponent implements OnInit {

  cancela: Cancela = new Cancela()
  passagem: Passagem = new Passagem()
  data: any = new Date();

  constructor(private route: ActivatedRoute,
    private router: Router,
    private serviceCancela: CancelaService,
    private servicePassagem: PassagemService) {

  }
  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        const idPassagem = params.get('id');
        this.servicePassagem.listById(idPassagem).subscribe(
          passagem => {
            this.passagem = passagem;
          }
        );
      }
    });
  }
  salvar() {
    this.cancela.dataCancelamento = formatDate(this.data, 'dd/MM/yyyy HH:mm', 'en-US')
    this.cancela.guidReserva = 0
    this.cancela.guidPassagem = this.passagem.guidPassagem
    this.cancela.checkin = false
    this.cancela.guidUsuario = 1
    this.serviceCancela.save(this.cancela).subscribe(
      () => {
        this.router.navigate(["/admin/cancela"])
      }
    )
  }

}
