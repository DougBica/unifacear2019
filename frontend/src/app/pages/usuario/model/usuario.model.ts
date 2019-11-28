import { Perfil } from '../../perfil1/model/perfil.model';

export class Usuario {

    guidUsuario: number;
	nome:string;
    email:string;
    dataNasc: any;
    cpf : String;
    tipoDeUsuario : String;
    foto : number;
    perfil: Perfil;
    perfis : Perfil [] = [];

}