package br.usjt.wssin3bn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.wssin3bn.model.Aluno;

@Repository
public interface AlunoRepo extends JpaRepository< Aluno, Long>{
	
	Aluno findOneById(Long id);
	/*Aluno listarAlunos(ArrayList<Aluno> alunos);
	Aluno salvar(Aluno aluno);
	Aluno deletar(Aluno aluno);*/
	
	public Aluno save(Aluno aluno);
	
	public List<Aluno> findAll();
	
}
