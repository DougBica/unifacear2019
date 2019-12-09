import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancela-remarca',
  templateUrl: './cancela-remarca.component.html',
  styleUrls: ['./cancela-remarca.component.scss']
})
export class CancelaRemarcaComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  cancelar(){
    this.router.navigate(["admin/cancela/salvar/1"])
  }
  remarcar(){
    this.router.navigate(["admin/remarca/salvar/1"])
  }

}
