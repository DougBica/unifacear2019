package edu.br.unifacear.webdev2019.passagem.entity;

public enum ClassePassagemEnum {
	
	PRIMEIRA_CLASSE("PRIMEIRA_CLASSE"),
	CLASSE_ECONOMICA("CLASSE_ECONOMICA"),
	CLASSE_EXECUTIVA("CLASSE_EXECUTIVA");
	
	private final String classePassagem;
    
	ClassePassagemEnum(String classePassagem){
        this.classePassagem= classePassagem;
    }
	
    public String getClassePassagem() {
        return classePassagem;
    }
}
