package br.usjt.wssin3bn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.wssin3bn.model.Turma;
import br.usjt.wssin3bn.repository.TurmaRepo;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepo turmaRepo;

	public Turma buscar(Long id) {
		return turmaRepo.findOneById(id);
	}


	public List <Turma> findAll() {
		return turmaRepo.findAll();
	}
	
}
