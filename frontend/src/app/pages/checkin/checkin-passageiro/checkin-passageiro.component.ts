import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkin-passageiro',
  templateUrl: './checkin-passageiro.component.html',
  styleUrls: ['./checkin-passageiro.component.scss']
})
export class CheckinPassageiroComponent implements OnInit {

  constructor() { }
  id: string;
  idLong: number;

  ngOnInit() {
    this.load();
  }

  load() {
    this.id = localStorage.getItem('email');
    console.log(this.id)
  }

}
