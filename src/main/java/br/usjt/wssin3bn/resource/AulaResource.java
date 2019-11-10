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

import br.usjt.wssin3bn.model.Aula;
import br.usjt.wssin3bn.service.AulaService;

@RestController
@RequestMapping("/aula")
public class AulaResource {
	
	@Autowired
	private AulaService aulaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        try {
            return ResponseEntity.ok(aulaService.buscar(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Aula não existe");
        }
    }
    
	@PostMapping("/add")
	public Aula createAula(@RequestBody Aula aula, HttpServletRequest request) {
		return aulaService.save(aula, request);

	}
	
	@GetMapping
	public ResponseEntity<?> listarAula() {
		List<Aula> aula = aulaService.listar();
		return ResponseEntity.ok(aula);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarDados(@PathVariable Long id, @RequestBody Aula aula, HttpServletRequest request) {
		return aulaService.alterarDados(id, aula, request);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id, HttpServletRequest request) {
		return aulaService.excluir(id, request);
	}
    
}
