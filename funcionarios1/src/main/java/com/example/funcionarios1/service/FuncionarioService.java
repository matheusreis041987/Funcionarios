package com.example.funcionarios1.service;

import java.util.List;
import java.util.Optional;

import com.example.funcionarios1.model.entity.Funcionario;

public interface FuncionarioService {

	 Funcionario salvar(Funcionario funcionario);
	
	 Funcionario atualizar(Funcionario funcionario);
	
	 void deletar(Funcionario funcionario);
	
	 List<Funcionario> buscar(Funcionario funcionario);
	 	 
	 Optional<Funcionario> consultarPorId (Long id); // se ele achar o Id, ele será um objeto produto, se não achar, será um objeto vazio
	
}
