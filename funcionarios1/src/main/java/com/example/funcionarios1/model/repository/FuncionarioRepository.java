package com.example.funcionarios1.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.funcionarios1.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
