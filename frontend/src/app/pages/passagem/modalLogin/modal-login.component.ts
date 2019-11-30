import { Component, EventEmitter, Output } from '@angular/core';

import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { LoginService } from '../../login/login.service';
import { Router } from '@angular/router';

@Component({
    selector: 'modal-login',
    templateUrl: './modal-login.component.html',
    styleUrls: ['./modal-login.component.scss']
})
export class ModalLoginComponent {
    closeResult: string;
    login: boolean = false;
    loginSystem: string;
    senha: string;
    @Output() conteudo = new EventEmitter<boolean>();

    constructor(
        private modalService: NgbModal,
        private loginService : LoginService,
        private router : Router) { }

    open(content) {
        if (localStorage.getItem('token') != undefined) {
            this.login = true;
        } else {
            this.login = false;
            this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
                this.closeResult = `Closed with: ${result}`;
            }, (reason) => {
                this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
            });
        }
        this.conteudo.emit(this.login);
    }

    private getDismissReason(reason: any): string {
        if (reason === ModalDismissReasons.ESC) {
            return 'by pressing ESC';
        } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
            return 'by clicking on a backdrop';
        } else {
            return `with: ${reason}`;
        }
    }

    submit() {
        console.log(this.loginSystem + " " + this.senha);
        this.loginService.login(this.loginSystem,this.senha).subscribe(
          user => {
            localStorage.setItem("token",user['token']);
            alert('logou');
            this.router.navigate(['/']);
          }
        )}
}