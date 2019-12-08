import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkin-menu',
  templateUrl: './checkin-menu.component.html',
  styleUrls: ['./checkin-menu.component.scss']
})
export class CheckinMenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  administrador() {
    this.router.navigate(['/admin/checkin-controle']);
  }

  embarque() {
    this.router.navigate(['/admin/embarque-controle'])
  }

  passageiro() {
    this.router.navigate(['/admin/checkin-passageiro'])
  }

}
