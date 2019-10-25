package br.usjt.wssin3bn.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "professor")
public class Professor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
	String nome;
	
	@NotBlank
	@Email
	String email;
	
	@NotBlank
	String senha;
	
	ArrayList<Turma> turmas = new ArrayList<Turma>(); 
	
	public Professor(){
		
	}
	
	public Professor(String nome, String email, String senha,  ArrayList<Turma> turmas){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.turmas = turmas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}

}
