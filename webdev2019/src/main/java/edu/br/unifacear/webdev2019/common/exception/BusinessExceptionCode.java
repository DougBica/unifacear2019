package edu.br.unifacear.webdev2019.common.exception;

public enum BusinessExceptionCode {
	
	ERR000("Erro não esperado"),
	ERR001("Usuário não encontrado"),
	ERR500("Bagagem não encontrada"),
	ERR501("Erro ao inserir bagagem"),
	ERR502("Erro ao alterar bagagem"),
	ERR503("Checkin não encontrado"),
	ERR504("Erro ao inserir checkin"),
	ERR505("Erro ao alterar checkin");
	
	private final String message;

	private BusinessExceptionCode(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
