export class Checkin {
    guidCheckin: number;
    token: string; // precisa
    guidUsuario: number; 
    guidPassagem: number; // precisa
    guidAeronave: number; // precisa
    checkinAtivo: boolean; // precisa
    altaBagagem: boolean;
    fotoCheckin: string; 
    indicadorFoto: boolean; 
    guidMilhagem: number; 
    dataCheckin: any; // data padrão
    guidStatus: number; // 1
}