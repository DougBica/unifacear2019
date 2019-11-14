import { Component, OnInit } from '@angular/core';
import { Bagagem } from '../model/bagagem.model';
import { BagagemService } from '../bagagem.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-bagagem-cadastrar',
  templateUrl: './bagagem-cadastrar.component.html',
  styleUrls: ['./bagagem-cadastrar.component.scss']
})
export class BagagemCadastrarComponent implements OnInit {

  bagagens: Bagagem = new Bagagem();
  guidBagagem: string;

  constructor(private bagagemService: BagagemService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params =>{
      if(params.get('id') != 'novo'){
        this.guidBagagem = params.get('id');
        this.bagagemService.loadById(this.guidBagagem).subscribe(
          bagagens =>{
            this.bagagens = bagagens;
          }
        )
      }
    })
  }

  salvar() {
    this.bagagemService.save(this.bagagens).subscribe(
      () => {
        this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Salvo', '', {
          disableTimeOut: false,
          closeButton: true,
          enableHtml: true,
          toastClass: "alert alert-info alert-with-icon",
          timeOut: 5000,
        });
        this.router.navigate(['/admin/bagagem-listar']);
      }
    )
  }
}
