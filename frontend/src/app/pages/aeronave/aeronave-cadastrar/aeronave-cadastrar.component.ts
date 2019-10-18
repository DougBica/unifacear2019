import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Aeronave } from '../model/aeronave.model';
import { AeronaveService } from '../aeronave.service';



@Component({
  selector: 'app-Aeronave-cadastrar',
  templateUrl: './aeronave-cadastrar.component.html',
  styleUrls: ['./aeronave-cadastrar.component.scss']
})
export class AeronaveCadastrarComponent implements OnInit {

  aeronave: Aeronave = new Aeronave();
  AeronaveService: any;

  constructor(private route: ActivatedRoute, 
    private aeronaveService : AeronaveService,
    private router : Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != 'novo') {
        var guidaeronave = params.get('id');
        this.aeronaveService.buscarPorId(guidaeronave).subscribe(
          aeronave => {
              this.aeronave = aeronave;
              console.log(this.aeronave);
          }
        );
      }
    });
  }

  salvar() {
    this.AeronaveService.salvar(this.aeronave).subscribe(
      () => {
        

        this.router.navigate(["/admin/aeronave/"]);    
      }
    );
  }

}
