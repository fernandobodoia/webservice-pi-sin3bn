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

import br.usjt.wssin3bn.model.Professor;
import br.usjt.wssin3bn.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService professorService;
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        try {
            return ResponseEntity.ok(professorService.buscar(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Professor nao existe");
        }
    }
    
	@PostMapping("/add")
	public Professor createProfessor(@RequestBody Professor professor, HttpServletRequest request) {
		return professorService.save(professor, request);

	}
	
	@GetMapping
	public ResponseEntity<?> listarProfessor() {
		List<Professor> professores = professorService.listar();
		return ResponseEntity.ok(professores);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarDados(@PathVariable Long id, @RequestBody Professor professor, HttpServletRequest request) {
		return professorService.alterarDados(id, professor, request);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id, HttpServletRequest request) {
		return professorService.excluir(id, request);
	}

}
