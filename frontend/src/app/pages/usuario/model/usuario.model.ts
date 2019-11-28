import { Perfil } from '../../perfil1/model/perfil.model';

export class Usuario {

    guidUsuario: number;
	nome:string;
    email:string;
    dataNasc: any;
    cpf : String;
<<<<<<< HEAD
    foto : String;
    tipoDeUsuario : String;
=======
    foto : number;
>>>>>>> 3fb853e57e8d24d66f2d98942f49da21d0fc25c2
    perfil: Perfil;
    perfis : Perfil [] = [];

}