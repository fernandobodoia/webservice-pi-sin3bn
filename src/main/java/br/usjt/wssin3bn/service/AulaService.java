package br.usjt.wssin3bn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.wssin3bn.model.Aula;
import br.usjt.wssin3bn.repository.AulaRepo;

@Service
public class AulaService {
	
	@Autowired
	private AulaRepo aulaRepo;
	
	public Aula buscar(Long id) {
		return aulaRepo.findOneById(id);
	}
	

}
