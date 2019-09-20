package edu.br.unifacear.webdev2019.passagem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ClassePassagemEnum {
	 @JsonProperty("PRIMEIRA_CLASSE")
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
