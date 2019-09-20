package edu.br.unifacear.webdev2019.common.exception;

public class MensagemErro {
	
	private String campo;
	private BusinessException erro;
	
	public MensagemErro(String campo, BusinessException erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public BusinessException getErro() {
		return erro;
	}
	
	

}
