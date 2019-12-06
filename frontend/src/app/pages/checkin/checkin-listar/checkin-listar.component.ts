import { Component, OnInit } from '@angular/core';
import { CheckinService } from '../checkin.service';
import { Checkin } from '../model/checkin.model';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkin-listar',
  templateUrl: './checkin-listar.component.html',
  styleUrls: ['./checkin-listar.component.scss']
})
export class CheckinListarComponent implements OnInit {

  checkins: Checkin[];
  checkin: Checkin = new Checkin();

  constructor(private checkinService: CheckinService, private toastr: ToastrService, private router: Router) { }

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
    this.router.navigate(["/admin/checkin-cadastrar/"+checkin.guidCheckin]);
  }

  baixarCheckin(token: number) {
    this.checkinService.loadById(token).subscribe(
      checkin => {
        this.checkin = checkin;
        console.log(this.checkin);
        this.checkin.guidStatus = 2;
        console.log(this.checkin.guidStatus);
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
