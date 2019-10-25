package br.usjt.wssin3bn.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.badRequest().body("Aula nao existe");
        }
    }
}
