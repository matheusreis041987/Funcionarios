package com.example.funcionarios1.service;

import java.util.List;

import com.example.funcionarios1.model.entity.Funcionario;

public interface FuncionarioService {

	 Funcionario salvar(Funcionario funcionario);
	
	 Funcionario atualizar(Funcionario funcionario);
	
	 void deletar(Funcionario funcionario);
	
	 List<Funcionario> buscar(Funcionario funcionario);
	
}
