import { Perfil } from '../../perfil/model/perfil.model';

export class Usuario {

    guidUsuario: number;
	nome:string;
    email:string;
    dataNasc: any;
    cpf : String;
    foto : String;
    perfil: Perfil;
    perfis : Perfil [] = [];

}