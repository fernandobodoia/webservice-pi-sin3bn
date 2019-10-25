package br.usjt.wssin3bn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.usjt.wssin3bn.model.Aula;
import br.usjt.wssin3bn.model.Professor;
import br.usjt.wssin3bn.model.Turma;

@Repository
public interface ProfessorRepo extends JpaRepository< Professor, Long> {
	
	Professor findOneById(Long id);
	
	public Professor save(Professor professor);
	
	public List<Professor> findAll();

}
