import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FabricanteCadastrarComponent } from '../fabricante-cadastrar/fabricante-cadastrar.component';
import { FormsModule } from '@angular/forms';
import { FabricanteListarComponent } from '../fabricante-listar/fabricante-listar.componet';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [FabricanteListarComponent, FabricanteCadastrarComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule 
  ]
})
export class FabricanteModule { }
