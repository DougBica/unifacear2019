import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogarComponent } from './logar/logar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [LogarComponent],
  imports: [
    CommonModule,
    FormsModule

  ]
})
export class LoginModule { }
