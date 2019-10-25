package br.usjt.wssin3bn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.wssin3bn.model.Aula;


@Repository
public interface AulaRepo extends JpaRepository<Aula, Long>{
	
	Aula findOneById(Long id);

}
