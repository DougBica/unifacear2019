import { Component, OnInit } from "@angular/core";

declare interface RouteInfo {
  path: string;
  title: string;
  rtlTitle: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  {
    path: "/admin/usuario",
    title: "Usuário",
    rtlTitle: "",
    icon: "icon-single-02",
    class: ""
  },
  {
    path: "/admin/tipoperfil",
    title: "Perfil",
    rtlTitle: "",
    icon: "icon-single-02",
    class: ""
  },
  {
    path: "/admin/checkin-menu",
    title: "Checkin",
    rtlTitle: "",
    icon: "icon-map-big",
    class: ""
  },  
  {
    path: "/cliente/buscar-passagem",
    title: "Passagem",
    rtlTitle: "",
    icon: "icon-send",
    class: ""
  },
  {
    path: "/admin/aeronave",
    title: "Aeronave",
    rtlTitle: "",
    icon: "icon-chart-pie-36",
    class: "",

   
    
  },
  {
    path: "/admin/passagem/alterar",
    title: "Alterar pasagem",
    rtlTitle: "",
    icon: "icon-chart-pie-36",
    class: ""
    },
  {
  path: "/admin/fabricante",
  title: "Fabricante",
  rtlTitle: "",
  icon: "icon-chart-pie-36",
  class: ""
  },
  
];

export const ROUTESCLIENTE: RouteInfo[] = [
  {
    path: "/admin/checkin-menu",
    title: "Checkin",
    rtlTitle: "",
    icon: "icon-map-big",
    class: ""
  },  
  {
    path: "/cliente/buscar-passagem",
    title: "Passagem",
    rtlTitle: "",
    icon: "icon-send",
    class: ""
  },
  {
    path: "/admin/passagem/alterar",
    title: "Alterar pasagem",
    rtlTitle: "",
    icon: "icon-chart-pie-36",
    class: ""
    },
];


@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.css"]
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() {}

  ngOnInit() {
    if(localStorage.getItem("typeUser") == "ADMIN"){
    this.menuItems = ROUTES.filter(menuItem => menuItem);
    }
    else
    this.menuItems = ROUTESCLIENTE.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if (window.innerWidth > 991) {
      return false;
    }
    return true;
  }
}
