package edu.br.unifacear.webdev2019.common.exception;

public class MensagemErro {
	
	private String campo;
	private String erro;
	
	public MensagemErro(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}
