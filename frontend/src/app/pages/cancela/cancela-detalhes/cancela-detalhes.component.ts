import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancela-detalhes',
  templateUrl: './cancela-detalhes.component.html',
  styleUrls: ['./cancela-detalhes.component.scss']
})
export class CancelaDetalhesComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  back(){
    this.router.navigate(["/admin/cancela"])
  }
}
