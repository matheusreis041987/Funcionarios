package com.example.funcionarios1.api.dto;

public class FuncionarioDto {

	private Long id;
	private String nome;
	private String cpf;
	private String cargo;
	private String especializacao;
	private String endereco;
	private Double salario;
	private boolean ehDefiente;
	private String email;
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
	public FuncionarioDto() {
		super();
		
	}
	
	
	
}
