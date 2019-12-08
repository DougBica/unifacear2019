import { Component, OnInit } from '@angular/core';
import { RemarcaService } from '../remarca.service';
import { Remarca } from '../model/remarca.model';
import { Router } from '@angular/router';
import { Passagem } from '../../passagem/model/passagem.model';
import { PassagemService } from '../../passagem/service/passagem.service';

@Component({
  selector: 'app-remarca-salvar',
  templateUrl: './remarca-salvar.component.html',
  styleUrls: ['./remarca-salvar.component.scss']
})
export class RemarcaSalvarComponent implements OnInit {
  remarca: Remarca = new Remarca()
  passagem: Passagem = new Passagem()
  constructor(private serviceRemarca: RemarcaService,
    private router: Router,
    private servicePassagem: PassagemService
  ) { }

  ngOnInit() {
    
  }
  save() {
    this.router.navigate(['/admin/remarca'])
    /*this.service.save(this.remarca).subscribe(
      () => {
      }
    )***/
  }
}
