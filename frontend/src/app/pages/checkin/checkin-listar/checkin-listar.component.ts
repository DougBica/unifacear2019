import { Component, OnInit } from '@angular/core';
import { CheckinService } from '../checkin.service';
import { Checkin } from '../model/checkin.model';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { Embarque } from '../model/embarque.model';
import { EmbarqueService } from '../embarque.service';

@Component({
  selector: 'app-checkin-listar',
  templateUrl: './checkin-listar.component.html',
  styleUrls: ['./checkin-listar.component.scss']
})
export class CheckinListarComponent implements OnInit {

  checkins: Checkin[];
  checkin: Checkin = new Checkin();
  embarque: Embarque = new Embarque();

  constructor(private checkinService: CheckinService, 
              private toastr: ToastrService, 
              private router: Router,
              private embarqueService: EmbarqueService) { }

  ngOnInit() {
    this.load();
  }

  load() {
    this.checkinService.load().subscribe(
      checkins => {
        this.checkins = checkins;
      }
    );
  }

  editar(checkin: Checkin) {
    this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Aguarde um momento.', '', {
      disableTimeOut: false,
      closeButton: true,
      enableHtml: true,
      toastClass: "alert alert-info alert-with-icon",
      timeOut: 5000,
    });
    this.router.navigate(["/admin/checkin-cadastrar/" + checkin.guidCheckin]);
  }

  baixarCheckin(token: number) {
    this.checkinService.loadById(token).subscribe(
      checkin => {
        this.checkin = checkin;
        this.checkin.guidStatus = 2;
        this.embarque.dataEmbarque = new Date();
        this.embarque.embarcou = false;
        this.embarque.guidCheckin = this.checkin.guidCheckin;
        this.embarque.guidUsuario = this.checkin.guidUsuario;
        this.embarque.guidPassagem = this.checkin.guidPassagem;
        this.embarque.embarcouIdf = 'Não';
        this.embarqueService.save(this.embarque).subscribe(
          () => {
          }
        )
        this.checkinService.save(this.checkin).subscribe(
          () => {
          }
        );
      }
    )
    this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Sucesso', '', {
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

}
