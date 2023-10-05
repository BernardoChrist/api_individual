package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service // é obrigatóro para os serviços
public class AlunoService {
	// 5 métodos - CRUD
	// recuperar todos alunos
	// recuperar um aluno pela sua chave primária
	// salvar um novo aluno
	// atualizar um determinado aluno
	// deletar um determinado aluno

	@Autowired // essa anotação é para injeção de dependencia, recursos de outro lugar
	AlunoRepository alunoRepo; // instanciando o repositorio do aluno

	// criando o metodo para recuperar todos os alunos
	public List<Aluno> listarAlunos() { // List pq são varios alunos
		return alunoRepo.findAll(); // o findAll irá listar todos
	}

	// criando metodo de recuperar aluno pela chave primária
	public Aluno buscarAlunoPorId(Integer numeromatriculaaluno) { // integer pq é o tipo da chave primária de aluno
		return alunoRepo.findById(numeromatriculaaluno).get(); // utilizamos o getbyid optional, depois o .get para
																// retornar um aluno.
	}

	// criando metodo para salvar um novo aluno
	public Aluno salvarAluno(Aluno novoAluno) { // salvando um novo aluno na entidade Aluno
		return alunoRepo.save(novoAluno); // o .save ja vai salvar
	}

	// criando metodo para atualizar um aluno existente
	public Aluno atualizarAluno(Aluno atualizaAluno) {
		return alunoRepo.save(atualizaAluno);
	}

	// criando metodo para deletar um determinado aluno
	public void deletarAluno(Aluno deletaAluno) { // será void pq não irá devolver nd,
		alunoRepo.delete(deletaAluno); // por isso também não tem o return
		/*
		 * Aluno confereAlunoDeletado =
		 * buscarAlunoPorId(aluno.getNumeroMatriculaAluno())
		 */
	}
}
