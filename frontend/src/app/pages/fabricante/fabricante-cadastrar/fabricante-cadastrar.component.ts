import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Fabricante } from '../model/fabricante.model';
import { FabricanteService } from '../model/fabricante.service';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-Fabricante-cadastrar',
  templateUrl: './fabricante-cadastrar.component.html',
  styleUrls: ['./fabricante-cadastrar.component.scss']
})
export class FabricanteCadastrarComponent implements OnInit {

  fabricante: Fabricante = new Fabricante();
  FabricanteveService: any;
  

  constructor(private route: ActivatedRoute, 
    private fabricanteService : FabricanteService,
    private toastr: ToastrService,
    private router : Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidFabricante = params.get('id');
        this.fabricanteService.buscarPorId(guidFabricante).subscribe(
          fabricante => {
              this.fabricante = fabricante;
              console.log(this.fabricante);
          }
        );
      }
    });
  }

  salvar() {
    if (this.fabricante.nomefabricante == undefined) {
      this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Verificar Campos', '', {
        disableTimeOut: false,
        closeButton: true,
        enableHtml: true,
        toastClass: "alert alert-info alert-with-icon",
        timeOut: 5000,
      });
      return;
    }

    this.fabricanteService.salvar(this.fabricante).subscribe(
      () => {

        this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span>Fabricante Salvo', '', {
          disableTimeOut: false,
          closeButton: true,
          enableHtml: true,
          toastClass: "alert alert-info alert-with-icon",
          timeOut: 5000,
        });
        this.router.navigate(["/admin/fabricante/"]);    
      }
    );
  }

}
