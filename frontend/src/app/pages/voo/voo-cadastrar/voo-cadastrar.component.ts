import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Voo } from '../model/voo.model';
import { VooService } from '../voo.service';



@Component({
  selector: 'app-voo-cadastrar',
  templateUrl: './voo-cadastrar.component.html',
  styleUrls: ['./voo-cadastrar.component.scss']
})
export class VooCadastrarComponent implements OnInit {

  voo: Voo = new Voo();

  constructor(private route: ActivatedRoute,
    private vooService: VooService,
    private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidVoo = params.get('id');
        this.vooService.buscarPorID(guidVoo).subscribe(
          voo => {
            this.voo = voo;
          }
        );
      }
    });
  }

  salvar() {
    this.vooService.salvar(this.voo).subscribe(
      () => {

        this.router.navigate(["/admin/voo/"]);
      }
    );
  }
}
