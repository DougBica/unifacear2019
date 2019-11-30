import { Component, OnInit } from '@angular/core';
import { RemarcaService } from '../remarca.service';
import { Remarca } from '../model/remarca.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-remarca-salvar',
  templateUrl: './remarca-salvar.component.html',
  styleUrls: ['./remarca-salvar.component.scss']
})
export class RemarcaSalvarComponent implements OnInit {
  remarca: Remarca = new Remarca()
  constructor(private service: RemarcaService, private router: Router) { }

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
