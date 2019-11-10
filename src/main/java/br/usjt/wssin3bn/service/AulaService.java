package br.usjt.wssin3bn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.usjt.wssin3bn.model.Aula;
import br.usjt.wssin3bn.repository.AulaRepo;

@Service
public class AulaService {

	@Autowired
	private AulaRepo aulaRepo;

	public Aula buscar(Long id) {
		return aulaRepo.findOneById(id);
	}

	public Aula save(Aula aula, HttpServletRequest request) {
		return aulaRepo.save(aula);
	}

	public List<Aula> listar() {
		return aulaRepo.findAll();
	}

	public ResponseEntity<?> alterarDados(Long id, Aula aulaParam, HttpServletRequest request) {
		Aula aula = aulaRepo.findById(id).get();
		aula.setPresenca(aulaParam.getPresenca());
		aulaRepo.save(aula);

		return ResponseEntity.ok("Dados alterados");
	}

	public ResponseEntity<?> excluir(Long id, HttpServletRequest request) {
		aulaRepo.delete(aulaRepo.findById(id).get());

		return ResponseEntity.ok("Registro excluído");

	}

}
