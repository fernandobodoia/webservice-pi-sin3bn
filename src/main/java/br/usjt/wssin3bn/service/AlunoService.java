package br.usjt.wssin3bn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.wssin3bn.model.Aluno;
import br.usjt.wssin3bn.repository.AlunoRepo;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepo alunoRepo;

	/*
	 * public Aluno cadastrar(Aluno aluno) { return salvar(aluno); }
	 * 
	 * private Aluno salvar(Aluno aluno) { return alunoRepo.salvar(aluno); }
	 * 
	 * public Aluno alterar(Aluno aluno, Aluno alunoNovo) {
	 * aluno.setEmail(alunoNovo.getEmail()); aluno.setSenha(alunoNovo.getSenha());
	 * aluno.setNome(alunoNovo.getNome()); aluno.setRa(alunoNovo.getRa());
	 * 
	 * salvar(aluno);
	 * 
	 * return aluno; }
	 * 
	 * public Aluno deletar(Aluno aluno) { return alunoRepo.deletar(aluno); }
	 */

	public Aluno buscar(Long id) {
		return alunoRepo.findOneById(id);
	}

	public Aluno save(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public List<Aluno> listar() {
		return alunoRepo.findAll();
	}
}