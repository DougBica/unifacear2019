import { Component, OnInit } from '@angular/core';
import { PassagemService } from '../../passagem/service/passagem.service';
import { EmbarqueService } from '../embarque.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Checkin } from '../model/checkin.model';
import { CheckinService } from '../checkin.service';
import { BagagemService } from '../bagagem.service';
import { Bagagem } from '../model/bagagem.model';
import { Usuario } from '../../usuario/model/usuario.model';
import { Status } from '../model/status.model';
import { Passagem } from '../../passagem/model/passagem.model';

@Component({
  selector: 'app-checkin-informacoes',
  templateUrl: './checkin-informacoes.component.html',
  styleUrls: ['./checkin-informacoes.component.scss']
})
export class CheckinInformacoesComponent implements OnInit {

  checkin: Checkin = new Checkin();
  guidCheckin: string;
  guidCheckin2: number;
  bagagens: Bagagem[];
  guidUsuario: number = 1;
  usuario: Usuario = new Usuario();
  status: Status = new Status();
  bagagem: Bagagem = new Bagagem();
  variavel: number;
  passagem: Passagem = new Passagem();
  idString: string;
  value : string;
  salvar : any;
  public myAngularxQrCode: string = null;

  constructor(private checkinService: CheckinService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService,
    private bagagemService: BagagemService,
    private passagemService: PassagemService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        this.guidCheckin = params.get('id');
        this.myAngularxQrCode = this.guidCheckin;
        this.guidCheckin2 = Number(this.guidCheckin);
        this.loadBagagem(this.guidCheckin2);
        this.checkinService.loadById(this.guidCheckin2).subscribe(
          checkin => {
            this.checkin = checkin;
            this.loadUser(this.checkin.guidUsuario);
            this.loadStatus(this.checkin.guidStatus);
            this.idString = this.checkin.guidPassagem.toString();
            this.loadPassagem(this.idString);
          }
        )
      }
    })
  }

  loadBagagem(id: number) {
    this.bagagemService.loadByGuidCheckin(id).subscribe(
      bagagem => {
        this.bagagens = bagagem;
      }
    );
  }

  loadUser(id: number) {
    this.checkinService.listarPorId(id).subscribe(
      usuario => {
        this.usuario = usuario;
      }
    )
  }

  loadStatus(id: number) {
    this.checkinService.lisarPorStatus(id).subscribe(
      status => {
        this.status = status;
      }
    )
  }

  loadPassagem(id: string) {
    this.passagemService.listById(id).subscribe(
      passagem => {
        this.passagem = passagem;
      }
    );
  }

}
