import { Component, OnInit, TemplateRef } from '@angular/core';
import {MatIconModule} from '@angular/material';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-buscar-passagem',
  templateUrl: './buscar-passagem.component.html',
  styleUrls: ['./buscar-passagem.component.css'],
})
export class BuscarPassagemComponent implements OnInit {
  modalRef: BsModalRef;

  constructor(private matIcon : MatIconModule,private modalService: BsModalService) { }

  ngOnInit() {
  }

 abrirModal(template: TemplateRef<any>) {
  this.modalRef = this.modalService.show(template);
}

}