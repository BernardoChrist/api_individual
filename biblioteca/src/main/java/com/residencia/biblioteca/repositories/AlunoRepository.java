package com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.biblioteca.entities.Aluno;

//todo repositorio é uma interface, e é obrigatório ter o extends JpaRepository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {// 2 parametros dentro do JPA, o 1º é a
																		// entidade do repositorio(Aluno) e o é o tipo
																		// de dado da
																		// chave primária da entidade aluno(Integer)

}
