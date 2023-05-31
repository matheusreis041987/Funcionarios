package com.example.funcionarios1.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.funcionarios1.api.controller.FuncionarioController;
import com.example.funcionarios1.model.entity.Funcionario;
import com.example.funcionarios1.model.repository.FuncionarioRepository;
import com.example.funcionarios1.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	FuncionarioRepository repository;
	private static int matriculap = 21103208;
	
	
	public FuncionarioServiceImpl(FuncionarioRepository fun) {
		this.repository = fun;
	}
	
	@Override
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		
		String [] nomeSeparado = funcionario.getNome().split(" "); 
		
		funcionario.setEmail(nomeSeparado[0].toLowerCase() + "." + nomeSeparado[nomeSeparado.length-1].toLowerCase() 
				+ funcionario.getCpf().substring(0,5) + "@ldwpuc.com.br" );
		
		
		//****MELHORIA*** ir no Banco de dados trazer a maior matrícula e acrescentar 1
		// hoje quando o sistema é fechado ele não consegue buscar as informações anteriores.
		
		Long x = funcionario.getId();
		
		funcionario.setMatricula((int) (matriculap + x));
		
		
		
		// conferir se o CPF está ok.
		/*if (! funcionario.getCpf().matches("[^0-9]+")) {
			
			return null;
		}*/
	
				
		return repository.save(funcionario);
	}

	@Override
	@Transactional
	public Funcionario atualizar(Funcionario funcionario) {
		
		try {
			if (funcionario.getMatricula() == null) {
				return funcionario;
			} else {
				return repository.save(funcionario);
			}
		} catch(Exception e) {
			e.getMessage();
			return funcionario;
		}
		
		
	}

	@Override
	@Transactional
	public void deletar(Funcionario funcionario) {
		
		try {
			Objects.requireNonNull(funcionario.getMatricula());
			 repository.delete(funcionario);
			
		} catch (NullPointerException e) {
			System.out.println("Erro##: " + e.getMessage() + " - favor inserir uma matrícula válida.");
		}
		
	}

	@Override
	@Transactional
	public List<Funcionario> buscar(Funcionario funcionario) {
		
		Example example = Example.of(funcionario);
		
		return repository.findAll(example);
	}

	@Override
	@Transactional
	public Optional<Funcionario> consultarPorId(Long id) {
				
		
		return repository.findById(id);
	}

	
	
	

}
