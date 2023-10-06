package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	// 5 métodos - CRUD
	// recuperar todos emprestimos
	// recuperar um emprestimo pela sua chave primária
	// salvar um novo Emprestimo
	// atualizar um determinado Emprestimo
	// deletar um determinado Emprestimo

	@Autowired
	EmprestimoRepository emprestimoRepo;

	public List<Emprestimo> listarEmprestimos() { // List pq são varios Emprestimos
		return emprestimoRepo.findAll();
	}

	public Emprestimo buscarEmprestimoPorId(Integer codigoEmprestimo) { // integer pq é o tipo da chave primária de
																		// Emprestimo
		return emprestimoRepo.findById(codigoEmprestimo).get();
	}

	public Emprestimo salvarEmprestimo(Emprestimo novoEmprestimo) { // salvando um novo emprestimo na entidade Emprestimo
		return emprestimoRepo.save(novoEmprestimo); // o .save ja vai salvar
	}

	public Emprestimo atualizarEmprestimo(Emprestimo atualizaEmprestimo) {
		return emprestimoRepo.save(atualizaEmprestimo);
	}

	public void deletarEmprestimo(Emprestimo deletaEmprestimo) { // será void pq não irá devolver nd,
		emprestimoRepo.delete(deletaEmprestimo); // por isso também não tem o return
		/*
		 * Aluno confereAlunoDeletado =
		 * buscarAlunoPorId(aluno.getNumeroMatriculaAluno())
		 */
	}
}
