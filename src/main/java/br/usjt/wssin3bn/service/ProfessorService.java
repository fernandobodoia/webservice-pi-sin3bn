package br.usjt.wssin3bn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.wssin3bn.model.Professor;
import br.usjt.wssin3bn.repository.ProfessorRepo;

@Service
public class ProfessorService {
	
	@Autowired
    private ProfessorRepo professorRepo;
	
	public Professor buscar(Long id) {
		return professorRepo.findOneById(id);
	}
	
	

}
