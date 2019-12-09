import { Perfil } from '../../perfil1/model/perfil.model';

export class Usuario {

    guidUsuario: number;
	nome:string;
    email:string;
    dataNasc: string;
    cpf : String;
    tipoDeUsuarios : String;
    foto : number;
    perfil: Perfil;
    perfis : Perfil [] = [];
    AlterarSenha : Boolean;
}