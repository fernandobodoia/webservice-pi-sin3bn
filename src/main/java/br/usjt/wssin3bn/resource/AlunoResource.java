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

import br.usjt.wssin3bn.model.Aluno;
import br.usjt.wssin3bn.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {
	
	@Autowired
	private AlunoService alunoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        try {
            return ResponseEntity.ok(alunoService.buscar(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Aluno nao existe");
        }
    }
	
	@PostMapping("/add")
	public Aluno createAluno(@RequestBody Aluno aluno, HttpServletRequest request) {
		return alunoService.save(aluno, request);

	}  
	
	@GetMapping
	public ResponseEntity<?> listarAlunos() {
		List<Aluno> alunos = alunoService.listar();
		return ResponseEntity.ok(alunos);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarDados(@PathVariable Long id, @RequestBody Aluno aluno, HttpServletRequest request) {
		return alunoService.alterarDados(id, aluno, request);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id, HttpServletRequest request) {
		return alunoService.excluir(id, request);
	}
	
	
}
