package br.usjt.wssin3bn.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/*@PostMapping
	public Aluno cadastrar(@RequestBody Aluno aluno) {
		return alunoService.cadastrar(aluno);
	}
	
	@PutMapping(value = "/alterar")
	public Aluno alterar(@RequestBody Aluno aluno, Aluno alunoNovo){
		return alunoService.alterar(aluno, alunoNovo);
	}*/

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
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoService.save(aluno);

	}
	
	@GetMapping
	public ResponseEntity<?> listarAlunos() {
		List<Aluno> alunos = alunoService.listar();
		return ResponseEntity.ok(alunos);
	}
	
	
}
