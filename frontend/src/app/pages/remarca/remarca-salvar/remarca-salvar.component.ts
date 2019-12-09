import { Component, OnInit } from '@angular/core';
import { RemarcaService } from '../remarca.service';
import { Remarca } from '../model/remarca.model';
import { Router, ActivatedRoute } from '@angular/router';
import { Passagem } from '../../passagem/model/passagem.model';
import { PassagemService } from '../../passagem/service/passagem.service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-remarca-salvar',
  templateUrl: './remarca-salvar.component.html',
  styleUrls: ['./remarca-salvar.component.scss']
})
export class RemarcaSalvarComponent implements OnInit {

  remarca: Remarca = new Remarca()
  passagem: Passagem = new Passagem()
  dataNova: any

  constructor(private serviceRemarca: RemarcaService,
    private router: Router,
    private servicePassagem: PassagemService,
    private route: ActivatedRoute
  ) { }

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
  alterarPassagem() {
    this.passagem.dataPartida = this.dataNova
    this.servicePassagem.salvar(this.passagem).subscribe()
  }
  save() {
    const data = new Date();
    this.remarca.dataPassagemAntiga = formatDate(this.passagem.dataPartida, 'dd/MM/yyyy HH:mm', 'en-US')
    this.remarca.dataPassagemNova = formatDate(this.dataNova, 'dd/MM/yyyy HH:mm', 'en-US')
    this.remarca.dataRemarcacao = formatDate(data, 'dd/MM/yyyy HH:mm', 'en-US')
    this.remarca.guidReserva = 0
    this.remarca.guidPassagem = this.passagem.guidPassagem
    this.remarca.guidUsuario = 0
    this.remarca.checkin = false
    this.serviceRemarca.save(this.remarca).subscribe(
      () => {
       this.alterarPassagem()
       this.router.navigate(["admin/passagem/alterar"])
      }
    )
  }
}
