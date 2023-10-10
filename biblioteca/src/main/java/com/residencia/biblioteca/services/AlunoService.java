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
	public Aluno buscarAlunoPorId(Integer numeroMatriculaAluno) { // integer pq é o tipo da chave primária de aluno

		return alunoRepo.findById(numeroMatriculaAluno).orElse(null); // utilizamos o getbyid optional, depois o .get
																		// para
																		// retornar um aluno.
		// temos que fazer essa alteração no service para depois alterar o controller
		// utilizamos o orElse, caso o numero do ID não exista, seria uma exception -
		// entao o que tivermos dentro do orElse, irá ser passado na pesquisa quando o
		// ID não for encontrado - - Caso o Id é encontrado, retorna o ID como se fosse
		// um .get()
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
	public Boolean deletarAluno(Aluno deletaAluno) { // boolena pq é mais facil de tratar no controller

		if (deletaAluno == null) {
			return false; // aqui estamos vendo se o aluno inserido para deletar é nulo
		}

		Aluno alunoExistente = buscarAlunoPorId(deletaAluno.getNumeroMatriculaAluno());

		if (alunoExistente == null) {
			return false; // aqui etamos vendo se o aluno existe no banco
		}

		alunoRepo.delete(deletaAluno);

		Aluno alunoContinuaExistindo = buscarAlunoPorId(deletaAluno.getNumeroMatriculaAluno());

		if (alunoContinuaExistindo == null) {
			return true;
		}
		return false;

	}
}
