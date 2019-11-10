package br.usjt.wssin3bn.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.wssin3bn.model.Turma;
import br.usjt.wssin3bn.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {

	@Autowired
	private TurmaService turmaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(turmaService.buscar(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Turma nao existe");
		}
	}

	@PostMapping("/add")

	public Turma createTurma(@RequestBody Turma turma, HttpServletRequest request) {
		return turmaService.save(turma, request);

	}
	
	@GetMapping
	public ResponseEntity<?> listarAula() {
		List<Turma> turmas = turmaService.listar();
		return ResponseEntity.ok(turmas);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarDados(@PathVariable Long id, @RequestBody Turma turma, HttpServletRequest request) {
		return turmaService.alterarDados(id, turma, request);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id, HttpServletRequest request) {
		return turmaService.excluir(id, request);
	}

}
