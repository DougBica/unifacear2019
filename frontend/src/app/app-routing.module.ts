import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { UsuarioListarComponent } from './pages/usuario/usuario-listar/usuario-listar.component';
import { AeronaveListarComponent } from './pages/aeronave/aeronave-listar/aeronave-listar.component';
import { AeronaveCadastrarComponent } from './pages/aeronave/aeronave-cadastrar/aeronave-cadastrar.component';
import { FabricanteCadastrarComponent } from './pages/fabricante/fabricante-cadastrar/fabricante-cadastrar.component';
import { FabricanteListarComponent } from './pages/fabricante/fabricante-listar/fabricante-listar.componet';

const routes: Routes = [
  {
    path: "admin",
    component: AdminLayoutComponent,
    children: [

      { path: 'usuario', component: UsuarioListarComponent },
      { path: 'aeronave', component: AeronaveListarComponent },
      { path: 'aeronave/:id', component: AeronaveCadastrarComponent },
      { path: 'fabricante/:id', component: FabricanteCadastrarComponent },
      { path: 'fabricante', component: FabricanteListarComponent },


    ]
  },
 
  {
    path: "",
    redirectTo: "dashboard",
    pathMatch: "full"
  },
  {
    path: "",
    component: AdminLayoutComponent,
    children: [
      {
        path: "",
        loadChildren:
          "./layouts/admin-layout/admin-layout.module#AdminLayoutModule"
      }
    ]
  }, {
    path: '',
    component: AuthLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './layouts/auth-layout/auth-layout.module#AuthLayoutModule'
      }
    ]
  },
  {
    path: "**",
    redirectTo: "dashboard"
  }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
