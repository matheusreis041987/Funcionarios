package com.example.funcionarios1.model.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "empresa", name = "funcionario")
public class Funcionario {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "cpf", nullable = false, length = 15)
	private String cpf;
	
	@Column(name = "cargo", nullable = false, length = 50)
	private String cargo;
	
	@Column(name = "especializacao", nullable = false, length = 50)
	private String especializacao;
	
	@Column(name = "endereco", nullable = false, length = 200)
	private String endereco;
	
	@Column(name = "salario", nullable = false)
	private Double salario;
	
	@Column(name = "eh_deficiente", nullable = false)
	private boolean ehDefiente;
	
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "matricula", nullable = false)
	private Integer matricula;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public boolean isEhDefiente() {
		return ehDefiente;
	}

	public void setEhDefiente(boolean ehDefiente) {
		this.ehDefiente = ehDefiente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargo, cpf, ehDefiente, email, endereco, especializacao, id, matricula, nome, salario);
	}

	
	public boolean equals(Funcionario fun) {
		
			if (this.nome == fun.nome && this.cpf == fun.cpf && this.matricula == fun.matricula) {
				return true;
			} else {
				return false;
			}
						
	}
	
	public String toString() {
		return "Funcionario(a) " + this.nome + " , matricula " + this.matricula + " , criado com sucesso";
	}
	
	
	
}
