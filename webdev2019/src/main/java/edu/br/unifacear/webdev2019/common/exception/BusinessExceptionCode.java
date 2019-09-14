package edu.br.unifacear.webdev2019.common.exception;

public enum BusinessExceptionCode {
	
	ERR000("Erro não esperado"),
	ERR001("Usuário não encontrado"),	
	ERR500("A reserva deve conter pelo menos 1 passagem");
	
	private final String message;

	private BusinessExceptionCode(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
