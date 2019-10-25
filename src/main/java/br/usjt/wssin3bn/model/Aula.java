package br.usjt.wssin3bn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "aula")
public class Aula {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPresenca() {
		return presenca;
	}

	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}

	private boolean presenca;
	
	public Aula(){
		
	}
	
	public Aula(boolean presenca) {
		this.presenca = presenca;
		
	}
	
	@Override
	public String toString() {
		return "Aula [id=" + id;
	}

}
