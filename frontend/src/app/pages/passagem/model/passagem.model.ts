import { Reserva } from './reserva.model';

export class Passagem {

    guidPassagem: number;
    guidRota: number;
    classePassagem:string;
    dataPartida: Date;
    origem: string;
    destino: string;
    isKid: boolean;
    active: boolean;
    valorPassagem: number;
    nomePassageiro: string;
    cpfPassageiro: string;  
    reserva: Reserva;

}