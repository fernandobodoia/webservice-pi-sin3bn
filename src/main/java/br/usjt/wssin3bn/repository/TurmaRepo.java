package br.usjt.wssin3bn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.wssin3bn.model.Turma;

@Repository
public interface TurmaRepo extends JpaRepository< Turma, Long> {
	
	Turma findOneById(Long id);
	
	public List<Turma> findAll();
	
	public Turma save(Turma turma);
}
