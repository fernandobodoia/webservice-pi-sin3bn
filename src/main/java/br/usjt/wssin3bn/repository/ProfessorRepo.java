package br.usjt.wssin3bn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.wssin3bn.model.Professor;

@Repository
public interface ProfessorRepo extends JpaRepository< Professor, Long> {
	
	Professor findOneById(Long id);

}
