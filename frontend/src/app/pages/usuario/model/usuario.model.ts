import { Perfil } from './perfil.model';

export class Usuario {

    guidUsuario: number;
	nome:string;
    email:string;
    dataNasc: any;

    perfis: Perfil[] = [];

}