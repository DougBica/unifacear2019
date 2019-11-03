import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CancelaService } from '../cancela.service';
import { Cancela } from '../model/cancela.model';

@Component({
  selector: 'app-cancela-detalhes',
  templateUrl: './cancela-detalhes.component.html',
  styleUrls: ['./cancela-detalhes.component.scss'],
})
export class CancelaDetalhesComponent implements OnInit {
  
  cancela: Cancela = new Cancela()
  nomeUsuario: string

  constructor(private route: ActivatedRoute, private router: Router, private service: CancelaService) {
    /*const nav = this.router.getCurrentNavigation();
    this.cancela = nav.extras.state.cancela;*/
    this.route.paramMap.subscribe(params => {
      if (params.get('id')) {
        var guidCancela = params.get('id');
        this.service.findByid(guidCancela).subscribe(
          cancela => {
            this.cancela = cancela;
          }
        );
      }
    });
   }

  ngOnInit() {
    
  }
  back(){
    this.router.navigate(["/admin/cancela"])
  }
  deletar(){
    this.service.delete(this.cancela.guidCancelar+"").subscribe(
      () =>{
        this.back()
      }
    )
  }
}
