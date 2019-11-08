import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from "./app.component";
import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { AppRoutingModule } from "./app-routing.module";
import { ComponentsModule } from "./components/components.module";
import { UsuarioListarComponent } from './pages/usuario/usuario-listar/usuario-listar.component';
import { UsuarioModule } from './pages/usuario/usuario.module';
import { CheckinModule } from './pages/checkin/checkin.module';
import { EmbarqueModule } from './pages/checkin/embarque.module';
import { BagagemModule } from './pages/checkin/bagagem.module';
import { LogintesteModule } from './pages/login/login.module';
import { RegisterModule } from "./pages/register/RegisterModule";
import { PerfilModule } from './pages/perfil/perfil.module';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    RegisterModule,
    LogintesteModule,
    UsuarioModule,
    PerfilModule,
    CheckinModule,
    BagagemModule,
    EmbarqueModule,
    ToastrModule.forRoot()
  ],
  declarations: [AppComponent, AdminLayoutComponent, AuthLayoutComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
