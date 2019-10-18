import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { UsuarioListarComponent } from './pages/usuario/usuario-listar/usuario-listar.component';
<<<<<<< HEAD
import { CheckinListarComponent } from './pages/checkin/checkin-listar/checkin-listar.component';
import { CheckinCadastrarComponent } from './pages/checkin/checkin-cadastrar/checkin-cadastrar.component';
=======
import { UsuarioCadastrarComponent } from './pages/usuario/usuario-cadastrar/usuario-cadastrar.component';
>>>>>>> 1c8bd25894a2184a808ead44446b0e840d69987d

const routes: Routes = [
  {
    path: "admin",
    component: AdminLayoutComponent,
    children: [

      { path: 'usuario', component: UsuarioListarComponent },
<<<<<<< HEAD
      { path: 'checkin-controle', component: CheckinListarComponent },
      { path: 'checkin-cadastrar/:id', component: CheckinCadastrarComponent }
=======
      { path: 'usuario/:id', component: UsuarioCadastrarComponent }
      

>>>>>>> 1c8bd25894a2184a808ead44446b0e840d69987d
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
