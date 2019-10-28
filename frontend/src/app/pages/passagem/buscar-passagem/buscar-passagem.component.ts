import { Component, OnInit } from '@angular/core';
import {MatIconModule} from '@angular/material';

@Component({
  selector: 'app-buscar-passagem',
  templateUrl: './buscar-passagem.component.html',
  styleUrls: ['./buscar-passagem.component.css']
})
export class BuscarPassagemComponent implements OnInit {

  constructor(private matIcon : MatIconModule) { }

  ngOnInit() {
  }

}