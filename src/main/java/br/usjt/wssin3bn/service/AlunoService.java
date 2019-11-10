package br.usjt.wssin3bn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.usjt.wssin3bn.model.Aluno;
import br.usjt.wssin3bn.repository.AlunoRepo;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepo alunoRepo;

	public Aluno buscar(Long id) {
		return alunoRepo.findOneById(id);
	}

	public Aluno save(Aluno aluno, HttpServletRequest request) {
		return alunoRepo.save(aluno);
	}
	
	public List<Aluno> listar() {
		return alunoRepo.findAll();
	}
	
	public ResponseEntity<?> alterarDados(Long id, Aluno alunoParam, HttpServletRequest request) {
		Aluno aluno = alunoRepo.findById(id).get();
		aluno.setNome(alunoParam.getNome());
		aluno.setEmail(alunoParam.getEmail());
		aluno.setRa(alunoParam.getRa());
		aluno.setSenha(alunoParam.getSenha());
		aluno.setTurma(alunoParam.getTurma());
		alunoRepo.save(aluno);

		return ResponseEntity.ok("Dados alterados");
	}
	
	public ResponseEntity<?> excluir(Long id, HttpServletRequest request) {
		alunoRepo.delete(alunoRepo.findById(id).get());

		return ResponseEntity.ok("Registro excluído");
	}
	
}