package edu.br.unifacear.webdev2019.common.exception;

public class MensagemErro {
	
	private String campo;
	private String erro;
	private String msg;
	
	public MensagemErro(String campo, String erro, String msg) {
		super();
		this.campo = campo;
		this.erro = erro;
		this.msg = msg;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	public String getMsg() {
		return msg;
	}
	
	

}
