import { Component, OnInit } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';
import { CheckinService } from '../checkin.service';
import { Checkin } from '../model/checkin.model';
import { Alert } from 'selenium-webdriver';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-checkin-listar',
  templateUrl: './checkin-listar.component.html',
  styleUrls: ['./checkin-listar.component.scss']
})
export class CheckinListarComponent implements OnInit {

  checkins: Checkin[];

  constructor(private checkinService: CheckinService, private toastr: ToastrService) { }

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
    console.log(checkin);
    this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Aguarde um momento.', '', {
      disableTimeOut: true,
      closeButton: true,
      enableHtml: true,
      toastClass: "alert alert-info alert-with-icon",
    });
  }

}
