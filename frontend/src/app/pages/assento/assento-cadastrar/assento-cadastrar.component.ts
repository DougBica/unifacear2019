import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Assento } from '../model/assento.model';
import { AssentoService } from '../assento.service';

@Component({
  selector: 'app-assento-cadastrar',
  templateUrl: './assento-cadastrar.component.html',
  styleUrls: ['./assento-cadastrar.component.scss']
})
export class AssentoCadastrarComponent implements OnInit {

  assento: Assento = new Assento();
  AssentoService: any;

  constructor(private route: ActivatedRoute, 
    private assentoService : AssentoService,
    private router : Router) { }

    ngOnInit() {
      this.route.paramMap.subscribe(params => {
        if (params.get('id') != 'novo') {
          var guidAssento = params.get('id');
          this.assentoService.buscarPorId(guidAssento).subscribe(
            assento => {
                this.assento = assento;
                console.log(this.assento);
            }
          );
        }
      });
    }
  
    salvar() {
      this.assentoService.salvar(this.assento).subscribe(
        () => {
          this.router.navigate(["/admin/assento/"]);    
        }
      );
    }
}
