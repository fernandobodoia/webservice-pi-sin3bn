package br.usjt.wssin3bn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	private String nome;
	
	public Turma() {
		
	}
	
	public Turma(String nome) {
		this.nome = nome;
		
	}
	@Override
	public String toString() {
		return "Turma [id=" + id + ", Nome [" + nome + "]";
	}

}
