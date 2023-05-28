package com.example.funcionarios1.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		funcionario.setMatricula(dto.getMatricula());
		
		if (dto.getId() != null) {
			funcionario.setId(dto.getId());
		}else if (dto.getEmail() != null) {
			funcionario.setEmail(dto.getEmail());
		} /*else if (dto.getMatricula() != null) {
			funcionario.setMatricula(dto.getMatricula());
		}*/
		
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
	
	@PutMapping("/atualizar/{id}") // {id} indica que o parâmetro da URL será variável (dinâmico)
	public ResponseEntity atualizar (@PathVariable("id") Long id, @RequestBody FuncionarioDto dto) {
		// o entity será o retorno da função, ou seja, o produto que foi consultado
		return service.consultarPorId(id).map( entity -> {
			
			try {
				Funcionario funcionario = converter(dto);
				funcionario.setId(entity.getId());
				service.atualizar(funcionario);
				return ResponseEntity.ok(funcionario);
				
			} catch (RegraDeNegocioException regraDeNegocio) {
				return ResponseEntity.badRequest().body(regraDeNegocio.getMessage());
			}
			
			
		}).orElseGet( () -> ResponseEntity.badRequest().body("O id do produto informado não foi encontrado na base de dados") );
		
		
	}
	
	@DeleteMapping("/deletar/{id}") //indica que o parâmetro da URL será variável (dinâmico)
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		
			return service.consultarPorId(id).map( entity -> {
				
				try {
					service.deletar(entity);
					return ResponseEntity.ok("Funcionario(a) " + entity.getNome() + ", matrícula " + entity.getMatricula() + ", foi deletado(a) com sucesso da base de dados com sucesso");
					//return new ResponseEntity(HttpStatus.NO_CONTENT); // para o caso de não retornar nada
				} catch (RegraDeNegocioException regraDeNegocio) {
					return ResponseEntity.badRequest().body(regraDeNegocio.getMessage());
				}
						
		}).orElseGet( () -> ResponseEntity.badRequest().body("O id do produto informado não foi encontrado na base de dados"));
		
		
	}
	
	
	
}
