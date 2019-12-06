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
    path: "/login",
    title: "Login",
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
    path: "/admin/embarque-controle",
    title: "Embarque",
    rtlTitle: "",
    icon: "icon-badge",
    class: ""
  }
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
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if (window.innerWidth > 991) {
      return false;
    }
    return true;
  }
}
