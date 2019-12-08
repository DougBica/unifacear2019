import { Component, OnInit } from '@angular/core';
import { Cancela } from '../model/cancela.model';
import { CancelaService } from '../cancela.service';
import { Router, ActivatedRoute } from '@angular/router';
import { formatDate, DatePipe } from '@angular/common';
import { Passagem } from '../../passagem/model/passagem.model';
import { PassagemService } from '../../passagem/service/passagem.service';
import { CheckinService } from '../../checkin/checkin.service';
import { Checkin } from '../../checkin/model/checkin.model';


@Component({
  selector: 'app-cancela-salvar',
  templateUrl: './cancela-salvar.component.html',
  styleUrls: ['./cancela-salvar.component.scss']
})
export class CancelaSalvarComponent implements OnInit {

  cancela: Cancela = new Cancela()
  passagem: Passagem = new Passagem()
  checkin: Checkin = new Checkin()
  checkins: Checkin[]
  data: any = new Date();

  constructor(private route: ActivatedRoute,
    private router: Router,
    private serviceCancela: CancelaService,
    private servicePassagem: PassagemService,
    private serviceCheckin: CheckinService) {

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
    this.cancela.checkin = false //this.checkin.checkinAtivo
    this.cancela.guidUsuario = 2
    this.serviceCancela.save(this.cancela).subscribe(
      () => {
        //this.router.navigate(["admin/cancela/lista"])
      }
    )
  }
  voltar() {
    console.log("Voltouuu")
  }
}
