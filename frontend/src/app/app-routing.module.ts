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
import { CheckinListarComponent } from './pages/checkin/checkin-listar/checkin-listar.component';
import { CheckinCadastrarComponent } from './pages/checkin/checkin-cadastrar/checkin-cadastrar.component';
import { UsuarioCadastrarComponent } from './pages/usuario/usuario-cadastrar/usuario-cadastrar.component';
import { AutenticacaoGuard } from './autenticacao.guard';
import { EmbarqueListarComponent } from './pages/checkin/embarque-listar/embarque-listar.component';
import { EmbarqueCadastrarComponent } from './pages/checkin/embarque-cadastrar/embarque-cadastrar.component';
import { LoginComponent } from './pages/login/login/login.component';
import { CarrinhoPassagemComponent } from './pages/passagem/carrinho-passagem/carrinho-passagem.component';
import { BuscarPassagemComponent } from './pages/passagem/buscar-passagem/buscar-passagem.component';

import { RegisterComponent } from './pages/register/register/register.component';
import { PerfilCadastrarComponent } from './pages/perfil1/perfil-cadastrar/perfil-cadastrar.component';
import { PerfilListarComponent } from './pages/perfil1/perfil-listar/perfil-listar.component';

const routes: Routes = [
  {
    path: "admin",
    //canActivate:[AutenticacaoGuard],
    component: AdminLayoutComponent,
    children: [
      { path: 'aeronave', component: AeronaveListarComponent },
      { path: 'aeronave/:id', component: AeronaveCadastrarComponent },
      { path: 'fabricante/:id', component: FabricanteCadastrarComponent },
      { path: 'fabricante', component: FabricanteListarComponent },
      { path: 'usuario', component: UsuarioListarComponent },
      { path: 'checkin-controle', component: CheckinListarComponent },
      { path: 'checkin-cadastrar/:id', component: CheckinCadastrarComponent },
      { path: 'usuario/:id', component: UsuarioCadastrarComponent },
      { path: 'tipoPerfil/:id', component : PerfilCadastrarComponent},
      { path: 'tipoperfil', component : PerfilListarComponent},
      { path: 'embarque-controle', component: EmbarqueListarComponent},
      { path: 'embarque-cadastro', component: EmbarqueCadastrarComponent}
   ]
  },
  { path: 'carrinho-passagem', component: CarrinhoPassagemComponent },
  { path: 'buscar-passagem', component: BuscarPassagemComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
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
