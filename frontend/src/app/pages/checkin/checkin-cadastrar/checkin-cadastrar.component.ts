import { Component, OnInit } from '@angular/core';
import { Checkin } from '../model/checkin.model';
import { CheckinService } from '../checkin.service';
import { Router, ActivatedRoute } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-checkin-cadastrar',
  templateUrl: './checkin-cadastrar.component.html',
  styleUrls: ['./checkin-cadastrar.component.scss']
})
export class CheckinCadastrarComponent implements OnInit {

  checkin: Checkin = new Checkin();
  guidCheckin: string;

  constructor(private checkinService: CheckinService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        this.guidCheckin = params.get('id');
        this.checkinService.loadById(this.guidCheckin).subscribe(
          checkin => {
            this.checkin = checkin;
          }
        )
      }
    })
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

}
