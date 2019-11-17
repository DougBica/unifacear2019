import { Assento } from '../../assento/model/assento.model';

  export class Aeronave {
    splice(index: any, arg1: number) {
      throw new Error("Method not implemented.");
    }
  
  
    guidaeronave: number;
    guidFabricante: number;
    nomeaeronave: string;
    comprimento: number;
    envergadura: number;
    altura: number;
    qtdmotor: number;
    pesovazio: number;
    pesodecolagem: number;
    paisorigem: string;
    modelo: string;
    velomaxima: number;
    assentos: Assento[] = [];
  
   
  
  
  }


