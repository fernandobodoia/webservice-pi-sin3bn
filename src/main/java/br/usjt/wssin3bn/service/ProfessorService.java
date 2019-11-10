package br.usjt.wssin3bn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public Professor save(Professor professor, HttpServletRequest request) {
		return professorRepo.save(professor);
	}
	
	public List<Professor> listar() {
		return professorRepo.findAll();
	}
	
	public ResponseEntity<?> alterarDados(Long id, Professor professorParam, HttpServletRequest request) {
		Professor professor = professorRepo.findById(id).get();
		professor.setNome(professorParam.getNome());
		professor.setEmail(professorParam.getEmail());
		professor.setSenha(professorParam.getSenha());
		professorRepo.save(professor);

		return ResponseEntity.ok("Dados alterados");
	}
	
	public ResponseEntity<?> excluir(Long id, HttpServletRequest request) {
		professorRepo.delete(professorRepo.findById(id).get());

		return ResponseEntity.ok("Registro excluído");
	}

}
