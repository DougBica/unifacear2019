package edu.br.unifacear.webdev2019.common.exception;

public enum BusinessExceptionCode {
	
	ERR000("Erro não esperado"),
	ERR001("Usuário não encontrado"),	
	ERR501("Erro de formulário"),
	ERR500("A reserva deve conter pelo menos 1 passagem"),
	ERR502("Reserva não existe"),
	ERR503("Passagem não encontrada"),
	ERR504("Nenhuma passagem encontrada para esta reserva"),
	ERR505("Nenhuma reserva encontrada para este usuário");
	
	private final String message;

	private BusinessExceptionCode(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
