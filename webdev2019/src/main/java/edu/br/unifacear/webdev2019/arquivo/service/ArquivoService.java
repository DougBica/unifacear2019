package edu.br.unifacear.webdev2019.arquivo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.arquivo.entity.Arquivo;
import edu.br.unifacear.webdev2019.arquivo.repository.ArquivoRepository;

@Service
public class ArquivoService {

	@Autowired
	ArquivoRepository arquivoRep;

	public Arquivo findOneById(Long guidArquivo) {
		return arquivoRep.findById(guidArquivo).get();
	}

	public Arquivo save(Arquivo arquivo) {
		return arquivoRep.save(arquivo);
	}
	
}
