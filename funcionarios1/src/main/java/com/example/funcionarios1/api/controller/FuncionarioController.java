package com.example.funcionarios1.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.funcionarios1.api.dto.FuncionarioDto;
import com.example.funcionarios1.exceptions.RegraDeNegocioException;
import com.example.funcionarios1.model.entity.Funcionario;
import com.example.funcionarios1.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
// http://localhost:8080/api/funcionario
public class FuncionarioController {

	FuncionarioService service;
	
	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}
	
	// método auxiliar para converter objetoDto em uma Entidade (funcionario)
	private Funcionario converter (FuncionarioDto dto) {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(dto.getNome());
		funcionario.setCpf(dto.getCpf());
		funcionario.setCargo(dto.getCargo());
		funcionario.setEspecializacao(dto.getEspecializacao());
		funcionario.setEndereco(dto.getEndereco());
		funcionario.setSalario(dto.getSalario());
		funcionario.setEhDefiente(dto.isEhDefiente());
		//funcionario.setEmail(dto.getEmail());
		//funcionario.setMatricula(dto.getMatricula());
		
		if (dto.getId() != null) {
			funcionario.setId(dto.getId());
		} 
		
		else if (dto.getEmail() != null) {
			funcionario.setEmail(dto.getEmail());
		} else if (dto.getMatricula() != null) {
			funcionario.setMatricula(dto.getMatricula());
		}
		
		return funcionario;
	}
	
	// http://localhost:8080/api/funcionario/salvar
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody FuncionarioDto dto) {
		
		try {
			
			Funcionario entidadeFuncionario = converter(dto);
			entidadeFuncionario = service.salvar(entidadeFuncionario);
			
			return ResponseEntity.ok(entidadeFuncionario);
			
		} catch (RegraDeNegocioException regraDeNegocio) {
			
			return ResponseEntity.badRequest().body(regraDeNegocio.getMessage());
		}
		
	}
}