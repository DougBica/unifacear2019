package edu.br.unifacear.webdev2019.common.exception;

public enum BusinessExceptionCode {
	
	ERR300("Erro não esperado"),
	ERR301("Usuário não encontrado");
	
	private final String message;

	private BusinessExceptionCode(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
