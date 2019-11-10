package br.usjt.wssin3bn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public Turma save(Turma turma, HttpServletRequest request) {
		return turmaRepo.save(turma);
	}
	
	public List<Turma> listar() {
		return turmaRepo.findAll();
	}
	
	public ResponseEntity<?> alterarDados(Long id, Turma turmaParam, HttpServletRequest request) {
		Turma turma = turmaRepo.findById(id).get();
		turma.setNome(turmaParam.getNome());
		turmaRepo.save(turma);

		return ResponseEntity.ok("Dados alterados");
	}
	
	public ResponseEntity<?> excluir(Long id, HttpServletRequest request) {
		turmaRepo.delete(turmaRepo.findById(id).get());

		return ResponseEntity.ok("Registro excluído");
	}
	

	
}
