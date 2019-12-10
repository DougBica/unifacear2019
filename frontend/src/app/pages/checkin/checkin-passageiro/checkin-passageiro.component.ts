import { Component, OnInit } from '@angular/core';
import { Checkin } from '../model/checkin.model';
import { CheckinService } from '../checkin.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkin-passageiro',
  templateUrl: './checkin-passageiro.component.html',
  styleUrls: ['./checkin-passageiro.component.scss']
})
export class CheckinPassageiroComponent implements OnInit {

  constructor(private checkinService: CheckinService,
    private toastr: ToastrService,
    private router: Router) { }
    
  id: string;
  idLong: number;
  checkins: Checkin[];

  ngOnInit() {
    this.load();
  }

  load() {
    this.id = localStorage.getItem('id');
    this.idLong = Number(this.id);
    this.checkinService.listarPorUsuario(this.idLong).subscribe(
      checkins => {
        this.checkins = checkins;
      }
    )
  }

  visualizar(id: number) {
    this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Aguarde um momento.', '', {
      disableTimeOut: false,
      closeButton: true,
      enableHtml: true,
      toastClass: "alert alert-info alert-with-icon",
      timeOut: 5000,
    });
    this.router.navigate(["/admin/checkin-ticket/"+id]);
  }

}
