import { Component, OnInit } from '@angular/core';
import { Checkin } from '../model/checkin.model';
import { CheckinService } from '../checkin.service';
import { Router, ActivatedRoute } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';
import { BagagemService } from '../bagagem.service';
import { Bagagem } from '../model/bagagem.model';
import { Usuario } from '../../usuario/model/usuario.model';
import { Status } from '../model/status.model';

@Component({
  selector: 'app-checkin-cadastrar',
  templateUrl: './checkin-cadastrar.component.html',
  styleUrls: ['./checkin-cadastrar.component.scss']
})
export class CheckinCadastrarComponent implements OnInit {

  checkin: Checkin = new Checkin();
  guidCheckin: string;
  guidCheckin2: number;
  bagagens: Bagagem[];
  guidUsuario: number = 1;
  usuario: Usuario = new Usuario();
  status: Status = new Status();
  bagagem: Bagagem = new Bagagem();
  variavel: number;

  constructor(private checkinService: CheckinService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService,
    private bagagemService: BagagemService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        this.guidCheckin = params.get('id');
        this.guidCheckin2 = Number(this.guidCheckin);
        this.loadBagagem(this.guidCheckin2);
        this.checkinService.loadById(this.guidCheckin2).subscribe(
          checkin => {
            this.checkin = checkin;
            this.loadUser(this.checkin.guidUsuario);
            this.loadStatus(this.checkin.guidStatus);
          }
        )
      }
    })
  }

  salvarBagagem(bagagem2: Bagagem) {
    bagagem2.guidCheckin = this.checkin.guidCheckin;
    bagagem2.valorexcesso = 230.9;
    if(bagagem2.pesoBagagem > 30.0) {
      bagagem2.valortotal = bagagem2.valorbagagem+bagagem2.valorexcesso;
    }
    else {
      bagagem2.valortotal = bagagem2.valorbagagem;
    }
    this.bagagemService.save(bagagem2).subscribe(
      () => {

      }
    )
    this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Salvo', '', {
      disableTimeOut: false,
      closeButton: true,
      enableHtml: true,
      toastClass: "alert alert-info alert-with-icon",
      timeOut: 5000,
    })
    setTimeout(() => {
      window.location.reload();
    }, 5000);
  }

  salvar() {
    this.checkinService.save(this.checkin).subscribe(
      () => {
        this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Salvo', '', {
          disableTimeOut: false,
          closeButton: true,
          enableHtml: true,
          toastClass: "alert alert-info alert-with-icon",
          timeOut: 5000,
        });
        this.router.navigate(['/admin/checkin-listar']);
      }
    )
  }

  loadBagagem(id: number) {
    this.bagagemService.loadByGuidCheckin(id).subscribe(
      bagagem =>{
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

  excluirBagagem(id: number) {
    console.log(id);
    this.bagagemService.excluir(id).subscribe(
      () => {

      }
    )
    this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Registro deletado', '', {
      disableTimeOut: false,
      closeButton: true,
      enableHtml: true,
      toastClass: "alert alert-info alert-with-icon",
      timeOut: 5000,
    })
    setTimeout(() => {
      window.location.reload();
    }, 2000);
  }

}
