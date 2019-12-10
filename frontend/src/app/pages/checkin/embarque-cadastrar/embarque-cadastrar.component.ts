import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { EmbarqueService } from '../embarque.service';
import { Embarque } from '../model/embarque.model';

@Component({
  selector: 'app-embarque-cadastrar',
  templateUrl: './embarque-cadastrar.component.html',
  styleUrls: ['./embarque-cadastrar.component.scss']
})
export class EmbarqueCadastrarComponent implements OnInit {

  embarque: Embarque = new Embarque();
  guidEmbarque: string;
  guidAeronave:any;
  Voo:any;
  teste: any;
 

  constructor(private embarqueService: EmbarqueService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        this.guidEmbarque = params.get('id');
        this.embarqueService.loadById(this.guidEmbarque).subscribe(
          embarque=> {
            this.embarque = embarque;
          }
        )
      }
    })
  }

  salvar() {
    this.embarqueService.save(this.embarque).subscribe(
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
