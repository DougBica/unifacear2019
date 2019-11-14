import { TipoPagamento } from './tipo-pagamento.model';

export class Reserva {

    guidReserva: number;
    guidUsuario: number;
    valorReserva: number;
    paid: boolean;
    active: boolean;
    tipoPagamento: TipoPagamento;

}